package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MaintenanceRegistrationController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for registering maintenance information for vehicles.
 */
public class MaintenanceRegistrationUI implements Runnable {
    private final MaintenanceRegistrationController controller;
    private final VehicleRepository vehicleRepository;
    private final Scanner scanner;
    private String maintenance;
    private double lastMaintenanceKm;
    private int userChoice;
    private int choice;

    /**
     * Constructs an instance of MaintenanceRegistrationUI.
     */
    public MaintenanceRegistrationUI() {
        this.controller = new MaintenanceRegistrationController();
        this.vehicleRepository = controller.getVehicleRepository();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the maintenance registration user interface.
     */
    @Override
    public void run() {
        boolean verification = printVehicles();
        if (verification) {
            System.out.println("\n\n--- Vehicle Maintenance Result ------------------------");
            requestData();
            submitData();
        }
    }

    private boolean printVehicles() {
        boolean verification = true;
        choice = 0;
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        System.out.println("\n--- Vehicles List -------------------------");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered yet.");
            verification = false;
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d - %s%n", choice, vehicle);
                choice++;
            }
        }
        return verification;
    }

    private void requestData() {
        userChoice = requestUserChoice();
        maintenance = requestMaintenance();
        lastMaintenanceKm = requestLastMaintenanceKm();
    }

    private int requestUserChoice() {
        userChoice = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

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
        System.out.print("Maintenance Result: ");
        return scanner.nextLine();
    }

    private double requestLastMaintenanceKm() {
        double lastMaintenanceKm = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Last Maintenance Km: ");
            String input = scanner.nextLine();
            try {
                lastMaintenanceKm = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return lastMaintenanceKm;
    }

    private void submitData() {
        Vehicle selectedVehicle = vehicleRepository.getVehicles().get(userChoice);
        selectedVehicle.setMaintenance(maintenance);
        selectedVehicle.setLastMaintenanceKm(lastMaintenanceKm);
    }
}
