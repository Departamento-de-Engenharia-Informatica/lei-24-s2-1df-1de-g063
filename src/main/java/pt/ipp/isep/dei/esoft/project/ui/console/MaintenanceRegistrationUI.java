package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MaintenanceRegistrationController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterVehicleController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MaintenanceRegistrationUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final MaintenanceRegistrationController controller;
    private final VehicleRepository vehicleRepository; // Added VehicleRepository
    private String brand;
    private String maintenance;
    public MaintenanceRegistrationUI() {
        controller = new MaintenanceRegistrationController();
        vehicleRepository = new VehicleRepository(); // Instantiated JobRepository
    }

    private MaintenanceRegistrationController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Vehicle Maintenance Result ------------------------");
        requestData();
        submitData();
        printMaintenance(); // Added printing jobs after submitting data
    }

    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        maintenance = requestMaintenance();
    }
    private String requestBrand(){
        System.out.println("Brand: ");
        return scan.nextLine();
    }
    private String requestModel(){
        System.out.println("Model: ");
        return scan.nextLine();
    }
    private String requestMaintenance() {
        System.out.println("Maintenance: ");
        return scan.nextLine();
    }

    private void submitData() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        int contador = 0;
        int index = 0;

        for(Vehicle vehicle : vehicles) {
            if(vehicle.getBrand().equals(requestBrand())){
                if(vehicle.getModel().equals(requestModel())){
                    index = contador;
                }
            }
            contador++;
        }
        Vehicle selectedVehicle = vehicleRepository.getVehicles().get(index);

       // Optional<Vehicle> maintenance = getController().Re
    }

    private void printMaintenance() {
        maintenance = Vehicle.getMaintenance();

        System.out.println("\n--- Maintenance Results -------------------------");
//        if (vehicles.isEmpty()) {
//            System.out.println("No vehicles registered yet.");
//        } else {
//            for (Vehicle vehicle : vehicles) {
//                System.out.println(vehicle); // Assuming Job class has overridden toString() method
//            }
//        }
    }
}
