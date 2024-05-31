package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignVehicleToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.Scanner;

public class AssignVehicleToEntryUI implements Runnable {

    private final AssignVehicleToEntryController controller;
    private final Scanner scanner;

    private int choiceVehicle;
    private int choiceEntry;

    public AssignVehicleToEntryUI(){
        this.controller = new AssignVehicleToEntryController();
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        System.out.println("\n\n--- Assign Vehicle to an Entry ------------------------");
        requestData();
    }

    public void requestData(){
        printVehicleList();
        System.out.println("Choose a vehicle:");
        choiceVehicle = scanner.nextInt();
        // Uncomment and adjust when entry logic is available
        // printEntryList();
        // System.out.println("Choose an entry:");
        // choiceEntry = scanner.nextInt();
        submitData();
    }

    public void submitData(){
        //controller.attributeVehicleToEntry(choiceVehicle, choiceEntry);
    }

    private void printVehicleList() {
        choiceVehicle = 0;
        List<Vehicle> vehicles = controller.getVehicles();
        System.out.println("\n--- Vehicles List -------------------------");
        if (vehicles.isEmpty()) {
            System.out.println("No Vehicles registered yet.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d - %s%n", choiceVehicle, vehicle);
                choiceVehicle++;
            }
        }
    }

    // Uncomment and adjust when entry logic is available
    // private void printEntryList() {
    //     choiceEntry = 0;
    //     List<Entry> entries = controller.getEntries();
    //     System.out.println("\n--- Entries List -------------------------");
    //     if (entries.isEmpty()) {
    //         System.out.println("No Entries registered yet.");
    //     } else {
    //         for (Entry entry : entries) {
    //             System.out.printf("%d - %s%n", choiceEntry, entry);
    //             choiceEntry++;
    //         }
    //     }
    // }

}
