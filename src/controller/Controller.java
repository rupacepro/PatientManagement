package controller;

import java.util.Date;
import java.util.Scanner;

import dao.PatientDAO;
import model.Patient;

public class Controller {
	PatientDAO dao = new PatientDAO();
	
	Scanner sc = new Scanner(System.in);
	
	public void displayAll() {
		System.out.println();
		dao.displayRecs();
	}
	
	public void insertRec() {
		System.out.println("Welcome to Insert Record Option in our Application");
		
		dao.displayRecs();
//		get the user input for Patient Object properties
		
		System.out.println("Please Enter the Id of new Patient:");
		
		int patientId = sc.nextInt();
		
//		Consume the space to take String input for name after int input id
		
		sc.nextLine();
		
		System.out.println("Please Enter the name of new Patient:");
		
		String name = sc.nextLine();
		
		System.out.println("Please Enter the contact of new Patient:");
		
		String contact = sc.nextLine();
		
		System.out.println("Please Enter the reason of visit:");
		
		String reason = sc.nextLine();
		
		System.out.println("Please Enter the Disease name: ");
		
		String disease = sc.nextLine();
		
//		create a patient object to store in db
		
		Patient patient_to_add = new Patient(patientId, name, contact, reason, disease, new Date());
		
//		call the insertRec() method and pass this employee as an object
		
		dao.insertRec(patient_to_add);
	}
	
	public void getASinglePatient() {
		System.out.println("Please Enter the Id of the patient: ");
		int patientId = sc.nextInt();
		sc.nextLine();
		dao.getRecById(patientId);
		System.out.println();
	}
	
	public void deleteAPatientRecord() {
		System.out.println("Enter the id of the patient to be deleted: ");
		int patientId = sc.nextInt();
		sc.nextLine();
		dao.deleteRecById(patientId);
		System.out.println();
	}
	
	public void updateAPatientRecord() {
		System.out.println("\nEnter the id of the patient to be updated: ");
		int patientId = sc.nextInt();
		sc.nextLine();
		dao.getRecById(patientId);
		
//		get the updated data for for Patient Object properties
		
		System.out.println("Please Enter new Id of the Patient:");
		
		int newId = sc.nextInt();
				
		sc.nextLine();
		
		System.out.println("Please Enter the updated name of the Patient:");
		
		String name = sc.nextLine();
		
		System.out.println("Please Enter the updated contact of the Patient:");
		
		String contact = sc.nextLine();
		
		System.out.println("Please Enter the new reason of visit:");
		
		String reason = sc.nextLine();
		
		System.out.println("Please Enter the new Disease name: ");
		
		String disease = sc.nextLine();
		
//		create a patient object to store in db
		
		Patient updatedPatient = new Patient(newId, name, contact, reason, disease, new Date());
		
		
		dao.updateRecById(patientId, updatedPatient);
	}
}
