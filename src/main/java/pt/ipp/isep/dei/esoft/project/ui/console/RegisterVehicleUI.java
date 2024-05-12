package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterVehicleController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * User interface for registering vehicles.
 */
public class RegisterVehicleUI implements Runnable {
    private final RegisterVehicleController controller;
    private final VehicleRepository vehicleRepository;
    private final Scanner scan;

    private String brand;
    private String model;
    private double tareWeight;
    private double grossWeight;
    private double currentKm;
    private LocalDate registerDate;
    private LocalDate acquisitionDate;
    private double checkUpFrequency;
    private Vehicle vehicle;

    /**
     * Constructs an instance of RegisterVehicleUI.
     */
    public RegisterVehicleUI() {
        this.controller = new RegisterVehicleController();
        this.vehicleRepository = controller.getVehicleRepository();
        this.scan = new Scanner(System.in);
    }

    /**
     * Runs the vehicle registration process.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Register Vehicle ------------------------");
        requestData();
        submitData();
        printVehicles();
    }

    private LocalDate requestDate(String prompt) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            String input = scan.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy/MM/dd:");
            }
        }

        return date;
    }

    private String requestBrand() {
        System.out.print("Brand: ");
        return scan.nextLine();
    }

    private String requestModel() {
        System.out.print("Model: ");
        return scan.nextLine();
    }

    private double requestNumbers(String prompt) {
        double number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            String input = scan.nextLine();

            try {
                number = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return number;
    }

    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        tareWeight = requestNumbers("Tare Weight: ");
        grossWeight = requestNumbers("Gross Weight: ");
        currentKm = requestNumbers("Current Km: ");
        registerDate = requestDate("Register Date (yyyy/MM/dd): ");
        acquisitionDate = requestDate("Acquisition Date (yyyy/MM/dd): ");
        checkUpFrequency = requestNumbers("Check Up Frequency: ");
    }

    private void submitData() {
        vehicle = controller.createVehicle(brand, model, tareWeight, grossWeight, currentKm, registerDate, acquisitionDate, checkUpFrequency);
        vehicleRepository.addVehicle(vehicle);
    }

    private void printVehicles() {
        int contador = 0;
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        System.out.println("\n--- Vehicles List -------------------------");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered yet.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d - %s%n", contador, vehicle);
                contador++;
            }
        }
    }
}
