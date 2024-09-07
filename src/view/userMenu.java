package view;

import java.util.Scanner;
import controller.Controller;

/**
 * The userMenu class provides a menu interface for interacting with the Patient Information System.
 */
public class userMenu {
    /**
     * Main method to start the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the Controller class
        Controller ctrl = new Controller();
        
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        int entry = 0;
        
        // Display welcome message
        System.out.println("\n\nWelcome to the Patient Information System");
        
        // Display menu and prompt user for input
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Enter 1 to display all Records.");
            System.out.println("Enter 2 to Insert Record");
            System.out.println("Enter 3 to get a single patient using patient id!!!");
            System.out.println("Enter 4 to delete patient by Id !!!");
            System.out.println("Enter 5 to update a record by Id !!!");
            System.out.println("Enter 6 to Exit the application !!!");
            System.out.print("Please Type your Entry: a number from 1 to 6 only: ");
            
            // Read user input
            entry = sc.nextInt();
            
            // Perform action based on user input
            switch (entry) {
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
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid entry. Please try again.");
                }
            }
        } while (entry != 6);
        
        // Close the Scanner object
        sc.close();
    }
}
