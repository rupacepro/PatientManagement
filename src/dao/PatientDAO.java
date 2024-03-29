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

public class PatientDAO {
	public Connection setupConnection() {
		
		// create a variable od connection type
		
		Connection con = null;
		
		// Write credentials
		
		String url = "jdbc:mysql://localhost:3306/patientrecords?autoReconnect=true&useSSL=false";
		
		String user = "root";
		String pwd = "Rupesh@123";
		
		//		load a driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// call the DriverManager class method
			
			con = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("Connection Successful!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
//	Methods to display records
	public List<Patient> displayRecs(){
		
		List<Patient> patients = new ArrayList<>();
		
		// Call the method for connection to database
		
		Connection con = setupConnection();
		
		String sql = "select * from patients";
		
		// Statement Interface is needed as it is a select Query
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Patient patient_from_top_row = new Patient(rs.getInt("patientId"), rs.getString("name"), rs.getString("contact"), rs.getString("reason"), rs.getString("disease"), rs.getDate("visitDate"));
				
				patients.add(patient_from_top_row);
			}
			
			System.out.println(patients);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patients;
	}
	
//	Method to insert row into the database table
	public void insertRec(Patient patient) {
		
		// call the method for connection
		
		Connection con = setupConnection();
		
		String sql = "insert into patients (patientId, name, contact, reason, disease, visitDate) values (?, ?, ?, ?, ?, ?)";
		
		// for ? in a query we use Preparedstatement.
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, patient.getPatientId());
			pstmt.setString(2, patient.getName());
			pstmt.setString(3, patient.getContact());
			pstmt.setString(4, patient.getReason());
			pstmt.setString(5, patient.getDisease());
			pstmt.setDate(6, new java.sql.Date(patient.getVisitDate().getTime()));
			
			int status = pstmt.executeUpdate();
			
			if(status>0) {
				System.out.println("Record inserted successfully !!!");
				displayRecs();
			}
			else {
				System.out.println("Try again it happens");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	method to retrieve a record by Id from database
	public Patient getRecById(int id_to_fetch_rec) {
//		Create a variable of Return Type Patient
		
		Patient patient_to_fetch_byId = null;
		
//		Call setupConnection to connect database
		
		Connection con = setupConnection();
		
//		write the Sql Query
		
		String sql = "select * from patients where patientId = ?";
		
//		For query with ? marks we use Prelparedstatement
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
//			Use the Setter Methods to set the value for ? mark
			pstmt.setInt(1, id_to_fetch_rec);
			
//			call the execute query to get the result set
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				create an Employee Object using top row in result set
				
				patient_to_fetch_byId = new Patient(rs.getInt("patientId"), rs.getString("name"), rs.getString("contact"), rs.getString("reason"), rs.getString("disease"), rs.getDate("visitDate"));
			
				System.out.println(patient_to_fetch_byId);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient_to_fetch_byId;
	}
	
//	method to delete record by id
	public void deleteRecById(int id_to_delete) {
//		call setupConnection()
		
		Connection con = setupConnection();
		
//		Write sql query
		
		String sql = "delete from patients where patientId=?";
		
//		For Query with ? marks we use PreparedStatement
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
//			set the values for ? mark
			
			pstmt.setInt(1, id_to_delete);
			
//			call executeUpdate() which returns 1 if query worked
			
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				System.out.println("Record deleted Successfully");
				displayRecs();
			}
			else {
				System.out.println("Try again!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	method to update patient record
	public void updateRecById(int curr_id, Patient updatedPatient) {
		
//		call setupConnection()
		
		Connection con = setupConnection();
		
		// write sql query
		
		String sql = "update patients set patientId = ?, name= ?, contact= ?, reason= ?, disease= ?, visitDate = ? where patientId = ?";
		
		// For Query with ? marks we use PreparedStatement
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
//			set the value for ? marks
			
			pstmt.setInt(1, updatedPatient.getPatientId());
			pstmt.setString(2, updatedPatient.getName());
			pstmt.setString(3, updatedPatient.getContact());
			pstmt.setString(4, updatedPatient.getReason());
			pstmt.setString(5, updatedPatient.getDisease());
			pstmt.setDate(6, new java.sql.Date(updatedPatient.getVisitDate().getTime()));
			pstmt.setInt(7, curr_id);
			
//			call executeUpdate
			
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				System.out.println("Record updated Successfully");
				displayRecs();
			}
			else {
				System.out.println("Try again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
}