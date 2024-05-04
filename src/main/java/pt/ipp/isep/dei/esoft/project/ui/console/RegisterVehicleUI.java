package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterVehicleController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Optional;
import java.util.List;

public class RegisterVehicleUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final RegisterVehicleController controller;
    private final VehicleRepository vehicleRepository;
    private String brand;
    private String model;
    private double tareWeight;
    private double grossWeight;
    private double currentKm;
    private LocalDate registerDate;
    private LocalDate acquisitionDate;
    private double checkUpFrequency;
    private Vehicle vehicle;

    public RegisterVehicleUI() {
        this.controller = new RegisterVehicleController();
        this.vehicleRepository = VehicleRepository.getInstance();
    }

    private RegisterVehicleController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register Vehicle ------------------------");
        requestData();
        submitData();
        printVehicles(); // Added printing jobs after submitting data
    }

    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        tareWeight = requestTareWeight();
        grossWeight = requestGrossWeight();
        currentKm = requestCurrentKm();
        registerDate = requestDate("Register Date (dd/MM/yyyy): ");
        acquisitionDate = requestDate("Acquisition Date (dd/MM/yyyy): ");
        checkUpFrequency = requestCheckUpFrequency();

    }

    private LocalDate requestDate(String prompt) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            String input = scan.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy:");
            }
        }

        return date;
    }

    private String requestBrand() {
        System.out.println("Brand: ");
        return scan.nextLine();
    }

    private String requestModel() {
        System.out.println("Model: ");
        return scan.nextLine();
    }

    private double requestTareWeight() {
        System.out.println("Tare Weight: ");
        return scan.nextDouble();
    }

    private double requestGrossWeight() {
        System.out.println("Gross Weight: ");
        return scan.nextDouble();
    }

    private double requestCurrentKm() {
        System.out.println("Current Km: ");
        double Km = scan.nextDouble();
        scan.nextLine();
        return Km;
    }

    private double requestCheckUpFrequency() {
        System.out.println("Check-Up Frequency: ");
        return scan.nextDouble();
    }

    private void submitData() {
        vehicle = controller.createVehicle(brand,model,tareWeight,grossWeight,currentKm,registerDate,acquisitionDate,checkUpFrequency);
        System.out.println(vehicle);
        vehicleRepository.addVehicle(vehicle);
    }

    private void printVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        System.out.println("\n--- Vehicles List -------------------------");
        if (vehicles.isEmpty()) {
           System.out.println("No vehicles registered yet.");
        } else {
           for (Vehicle vehicle : vehicles) {
               System.out.println(vehicle);
           }
        }
    }
}
