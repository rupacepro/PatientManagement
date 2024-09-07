package controller;

import java.util.Date;
import java.util.Scanner;

import dao.PatientDAO;
import model.Patient;

/**
 * The Controller class manages the interaction between the user interface and the data access objects.
 */
public class Controller {
    // Data Access Object for patient records
    PatientDAO dao = new PatientDAO();
    
    // Scanner object for user input
    Scanner sc = new Scanner(System.in);
    
    /**
     * Display all patient records.
     */
    public void displayAll() {
        System.out.println();
        dao.displayRecs();
    }
    
    /**
     * Insert a new patient record.
     */
    public void insertRec() {
        System.out.println("Welcome to Insert Record Option in our Application");
        
        dao.displayRecs();
        
        // Get user input for patient properties
        System.out.println("Please Enter the Id of new Patient:");
        int patientId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        System.out.println("Please Enter the name of new Patient:");
        String name = sc.nextLine();
        
        System.out.println("Please Enter the contact of new Patient:");
        String contact = sc.nextLine();
        
        System.out.println("Please Enter the reason of visit:");
        String reason = sc.nextLine();
        
        System.out.println("Please Enter the Disease name:");
        String disease = sc.nextLine();
        
        // Create a patient object
        Patient patientToAdd = new Patient(patientId, name, contact, reason, disease, new Date());
        
        // Insert the patient record
        dao.insertRec(patientToAdd);
    }
    
    /**
     * Retrieve a single patient record by patient id.
     */
    public void getASinglePatient() {
        System.out.println("Please Enter the Id of the patient:");
        int patientId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        dao.getRecById(patientId);
        System.out.println();
    }
    
    /**
     * Delete a patient record by patient id.
     */
    public void deleteAPatientRecord() {
        System.out.println("Enter the id of the patient to be deleted:");
        int patientId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        dao.deleteRecById(patientId);
        System.out.println();
    }
    
    /**
     * Update a patient record by patient id.
     */
    public void updateAPatientRecord() {
        System.out.println("\nEnter the id of the patient to be updated:");
        int patientId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        dao.getRecById(patientId);
        
        // Get updated data for patient properties
        System.out.println("Please Enter new Id of the Patient:");
        int newId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        System.out.println("Please Enter the new name of the Patient:");
        String name = sc.nextLine();
        
        System.out.println("Please Enter the new contact of the Patient:");
        String contact = sc.nextLine();
        
        System.out.println("Please Enter the current reason of visit:");
        String reason = sc.nextLine();
        
        System.out.println("Please Enter the Disease name:");
        String disease = sc.nextLine();
        
        // Create a patient object with updated data
        Patient updatedPatient = new Patient(newId, name, contact, reason, disease, new Date());
        
        // Update the patient record
        dao.updateRecById(patientId, updatedPatient);
    }
}
