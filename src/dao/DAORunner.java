package dao;

import java.util.Date;

import model.Patient;

/**
 * The DAORunner class contains the main method to demonstrate the functionality of the PatientDAO class.
 */
public class DAORunner {
    /**
     * Main method to demonstrate CRUD operations on patient records.
     */
    public static void main(String[] args) {
        PatientDAO obj = new PatientDAO();
        
        // Uncomment the desired operation to demonstrate
        
        // Displays records from the database table
        // obj.displayRecs();
        
        // Insert a record to the table
        // Patient newPatient = new Patient(10, "Laxmi Sharma", "987-654-3215", "Back pain", "Sciatica", new Date());
        // obj.insertRec(newPatient);

        // Retrieve patient record by id
        // obj.getRecById(6);
        
        // Delete patient record by id
        // obj.deleteRecById(6);
        
        // Update the patient record
        // Patient updatedPatient = new Patient(6, "Laxmi Sharma", "987-654-3215", "Back pain", "Sciatica", new Date());
        // obj.updateRecById(1, updatedPatient);
    }
}
