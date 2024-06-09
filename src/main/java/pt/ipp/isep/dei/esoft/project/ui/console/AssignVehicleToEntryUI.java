package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignVehicleToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.util.List;
import java.util.Scanner;

/**
 * The AssignVehicleToEntryUI class represents the console-based user interface for assigning vehicles to entries.
 * It interacts with the AssignVehicleToEntryController to manage the assignment process.
 */
public class AssignVehicleToEntryUI implements Runnable {

    private final AssignVehicleToEntryController controller;
    private final Scanner scanner;

    private int choiceVehicle;
    private int choiceEntry;

    /**
     * Constructs an AssignVehicleToEntryUI object.
     */
    public AssignVehicleToEntryUI() {
        this.controller = new AssignVehicleToEntryController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Executes the UI functionality.
     */
    public void run() {
        System.out.println("\n\n--- Assign Vehicle to an Entry ------------------------");
        requestData();
    }

    /**
     * Requests data from the user to assign vehicles to entries.
     */
    public void requestData() {
        System.out.println("How many vehicles do you want to add?");
        int numVehicles = scanner.nextInt();
        for (int i = 0; i < numVehicles; i++) {
            do {
                printVehicleList();
                System.out.println("Choose a vehicle:");
                // Input validation
                // ...
                // Choice validation
                // ...
                // Vehicle assignment
                break;
            } while (true);

            do {
                printEntryList();
                System.out.println("Choose an entry:");
                // Input validation
                // ...
                // Choice validation
                // ...
                break;
            } while (true);

            submitData();
        }
    }

    /**
     * Submits the user input data to assign the selected vehicle to the selected entry.
     */
    public void submitData() {
        controller.attributeVehicleToEntry(choiceVehicle, choiceEntry);
    }

    /**
     * Prints the list of vehicles for selection.
     */
    private void printVehicleList() {
        // Printing vehicle list
        // ...
    }

    /**
     * Prints the list of entries for selection.
     */
    private void printEntryList() {
        // Printing entry list
        // ...
    }
}
