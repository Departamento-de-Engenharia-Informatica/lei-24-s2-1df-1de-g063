package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignVehicleToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

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
    System.out.println("How many vehicles do you want to add?");
    int numVehicles = scanner.nextInt();
    for (int i = 0; i < numVehicles; i++) {
        do {
            printVehicleList();
            System.out.println("Choose a vehicle:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next();
            }
            choiceVehicle = scanner.nextInt();
            if (choiceVehicle == -1) {
                return;
            }
            if (choiceVehicle < 0 || choiceVehicle >= controller.getVehicles().size()) {
                System.out.println("Invalid choice. Please choose a number from the list:");
                continue;
            }
            break;
        } while (true);

        do {
            printEntryList();
            System.out.println("Choose an entry:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next();
            }
            choiceEntry = scanner.nextInt();
            if (choiceEntry == -1) {
                return;
            }
            if (choiceEntry < 0 || choiceEntry >= controller.getEntries().size()) {
                System.out.println("Invalid choice. Please choose a number from the list:");
                continue;
            }
            break;
        } while (true);

        submitData();
    }
}

    public void submitData(){
        controller.attributeVehicleToEntry(choiceVehicle, choiceEntry);
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

     private void printEntryList() {
         choiceEntry = 0;
         List<Entry> entries = controller.getEntries();
         System.out.println("\n--- Entries List -------------------------");
         if (entries.isEmpty()) {
             System.out.println("No Entries registered yet.");
         } else {
             for (Entry entry : entries) {
                 System.out.printf("%d - %s%n", choiceEntry, entry);
                 choiceEntry++;
             }
         }
     }

}
