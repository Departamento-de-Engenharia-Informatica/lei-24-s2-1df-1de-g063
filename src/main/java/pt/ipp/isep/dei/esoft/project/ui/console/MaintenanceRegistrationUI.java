package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MaintenanceRegistrationController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.List;
import java.util.Scanner;

public class MaintenanceRegistrationUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final MaintenanceRegistrationController controller;
    private final VehicleRepository vehicleRepository;
    private String maintenance;
    private double lastMaintenanceKm;
    private int userChoice;
    private int choice;

    public MaintenanceRegistrationUI() {
        controller = new MaintenanceRegistrationController();
        vehicleRepository = VehicleRepository.getInstance();
    }

    private MaintenanceRegistrationController getController() {
        return controller;
    }

    public void run() {
        printVehicles();
        System.out.println("\n\n--- Vehicle Maintenance Result ------------------------");
        requestData();
        submitData();
    }

    private void printVehicles() {
        choice = 0;
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        System.out.println("\n--- Vehicles List -------------------------");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered yet.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d - %s%n",choice,vehicle);
                choice++;
            }
        }
    }

    private void requestData() {
        userChoice = requestUserChoice();
        maintenance = requestMaintenance();
        lastMaintenanceKm = requestLastMaintenanceKm();
    }

    private int requestUserChoice() {
        int userChoice = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your choice: ");
            String input = scan.nextLine();

            try {
                userChoice = Integer.parseInt(input);
                if (userChoice >= 0 && userChoice <= choice - 1) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and " + (choice - 1) + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return userChoice;
    }

    private String requestMaintenance() {
        scan.nextLine();
        System.out.print("Maintenance Result: ");
        return scan.nextLine();
    }

    private double requestLastMaintenanceKm() {
        double LastMaintenanceKm = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Last Maintenance Km: ");
            String input = scan.nextLine();

            try {
                LastMaintenanceKm = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return LastMaintenanceKm;
    }


    private void submitData() {
        Vehicle selectedVehicle = vehicleRepository.getVehicles().get(userChoice);

        selectedVehicle.setMaintenance(maintenance);
        selectedVehicle.setLastMaintenanceKm(lastMaintenanceKm);
    }

}
