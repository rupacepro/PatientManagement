package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

/**
 * The PatientDAO class handles database operations related to the Patient model.
 */
public class PatientDAO {
    /**
     * Establishes a database connection.
     * 
     * @return Connection object representing the database connection
     */
    public Connection setupConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/patientrecords?autoReconnect=true&useSSL=false";
        String user = "root";
        String pwd = "Rupesh@123";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection Successful!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    /**
     * Retrieves all patient records from the database.
     * 
     * @return List of Patient objects representing the records retrieved
     */
    public List<Patient> displayRecs() {
        List<Patient> patients = new ArrayList<>();
        Connection con = setupConnection();
        String sql = "select * from patients";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("patientId"), rs.getString("name"),
                        rs.getString("contact"), rs.getString("reason"), rs.getString("disease"),
                        rs.getDate("visitDate"));
                patients.add(patient);
            }
            System.out.println(patients);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
    
    /**
     * Inserts a new patient record into the database.
     * 
     * @param patient Patient object representing the record to be inserted
     */
    public void insertRec(Patient patient) {
        Connection con = setupConnection();
        String sql = "insert into patients (patientId, name, contact, reason, disease, visitDate) values (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, patient.getPatientId());
            pstmt.setString(2, patient.getName());
            pstmt.setString(3, patient.getContact());
            pstmt.setString(4, patient.getReason());
            pstmt.setString(5, patient.getDisease());
            pstmt.setDate(6, new java.sql.Date(patient.getVisitDate().getTime()));
            
            int status = pstmt.executeUpdate();
            
            if (status > 0) {
                System.out.println("Record inserted successfully !!!");
                displayRecs();
            } else {
                System.out.println("Try again it happens");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves a patient record by ID from the database.
     * 
     * @param id_to_fetch_rec The ID of the patient record to retrieve
     * @return Patient object representing the record retrieved
     */
    public Patient getRecById(int id_to_fetch_rec) {
        Patient patient_to_fetch_byId = null;
        Connection con = setupConnection();
        String sql = "select * from patients where patientId = ?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id_to_fetch_rec);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                patient_to_fetch_byId = new Patient(rs.getInt("patientId"), rs.getString("name"),
                        rs.getString("contact"), rs.getString("reason"), rs.getString("disease"),
                        rs.getDate("visitDate"));
                System.out.println(patient_to_fetch_byId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient_to_fetch_byId;
    }
    
    /**
     * Deletes a patient record by ID from the database.
     * 
     * @param id_to_delete The ID of the patient record to delete
     */
    public void deleteRecById(int id_to_delete) {
        Connection con = setupConnection();
        String sql = "delete from patients where patientId=?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id_to_delete);
            int status = pstmt.executeUpdate();
            
            if (status > 0) {
                System.out.println("Record deleted Successfully");
                displayRecs();
            } else {
                System.out.println("Try again!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates a patient record in the database.
     * 
     * @param curr_id The ID of the patient record to update
     * @param updatedPatient Patient object representing the updated record
     */
    public void updateRecById(int curr_id, Patient updatedPatient) {
        Connection con = setupConnection();
        String sql = "update patients set patientId = ?, name= ?, contact= ?, reason= ?, disease= ?, visitDate = ? where patientId = ?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, updatedPatient.getPatientId());
            pstmt.setString(2, updatedPatient.getName());
            pstmt.setString(3, updatedPatient.getContact());
            pstmt.setString(4, updatedPatient.getReason());
            pstmt.setString(5, updatedPatient.getDisease());
            pstmt.setDate(6, new java.sql.Date(updatedPatient.getVisitDate().getTime()));
            pstmt.setInt(7, curr_id);
            
            int status = pstmt.executeUpdate();
            
            if (status > 0) {
                System.out.println("Record updated Successfully");
                displayRecs();
            } else {
                System.out.println("Try again!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
