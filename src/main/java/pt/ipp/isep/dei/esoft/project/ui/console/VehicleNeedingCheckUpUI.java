package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.VehicleNeedingCheckUpController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.List;
import java.util.Scanner;

public class VehicleNeedingCheckUpUI implements Runnable {
    Scanner scan = new Scanner(System.in);

    private final VehicleNeedingCheckUpController controller;
    private final VehicleRepository vehicleRepository;
    private double currentKm;
    private double checkUpFrequency;
    private double lastMaintenanceKm;
    private Vehicle vehicle;


    public VehicleNeedingCheckUpUI() {
        this.controller = new VehicleNeedingCheckUpController();
        this.vehicleRepository = VehicleRepository.getInstance();
    }

    private VehicleNeedingCheckUpController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Vehicle Needing Check-Up List ------------------------");
        printVehicles();
    }

    private void printVehicles() {
        List<Vehicle> vehiclesNeedingCheckUp = controller.getVehiclesNeedingCheckUp();
        System.out.println("\n--- Vehicles Needing Check-Up -------------------------");
        if (vehiclesNeedingCheckUp.isEmpty()) {
            System.out.println("No vehicles need a check-up.");
        } else {
            for (Vehicle vehicle : vehiclesNeedingCheckUp) {
                System.out.println(vehicle);
            }
        }
    }
}