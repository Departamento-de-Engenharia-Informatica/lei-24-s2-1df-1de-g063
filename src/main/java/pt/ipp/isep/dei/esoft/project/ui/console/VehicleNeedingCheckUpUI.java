package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.VehicleNeedingCheckUpController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

public class VehicleNeedingCheckUpUI implements Runnable {
    private final VehicleNeedingCheckUpController controller;

    public VehicleNeedingCheckUpUI() {
        this.controller = new VehicleNeedingCheckUpController();
    }

    public void run() {
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