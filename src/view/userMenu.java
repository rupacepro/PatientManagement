package view;

import java.util.Scanner;

import controller.Controller;

public class userMenu {
	public static void main(String[] args) {
//		Object of Controller
		
		Controller ctrl = new Controller();
		
		Scanner sc = new Scanner(System.in);
		
		int entry = 0;
		
		System.out.println("\n\nWelcome to the Patient Information System");
		do {
            System.out.println("-----------------------------------------");
            System.out.println("Enter 1 to display all Records.");
            System.out.println("Enter 2 to Insert Record");
            System.out.println("Enter 3 to get a single patient using patient id!!!");
            System.out.println("Enter 4 to delete patient by Id !!!");
            System.out.println("Enter 5 to update a record by Id !!!");
            System.out.println("Enter 6 to Exit the application !!!");
            System.out.print("Please Type your Entry: a number from 1 to 6 only: ");

            entry = sc.nextInt();

            switch(entry) {
                case 1: {
                    ctrl.displayAll();
                    break;
                }
                case 2: {
                    ctrl.insertRec();
                    break;
                }
                case 3: {
                    ctrl.getASinglePatient();
                    break;
                }
                case 4: {
                    ctrl.deleteAPatientRecord();
                    break;
                }
                case 5: {
                    ctrl.updateAPatientRecord();
                    break;
                }
                case 6: {
                    System.out.println("Exiting the application...");
                    break;
                }
                default: {
                    System.out.println("Invalid entry. Please try again.");
                }
            }
        } while (entry != 6);
		
	}
}
