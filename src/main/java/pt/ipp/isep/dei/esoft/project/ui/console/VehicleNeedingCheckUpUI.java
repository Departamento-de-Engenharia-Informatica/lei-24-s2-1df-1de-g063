package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.VehicleNeedingCheckUpController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

import java.util.List;

/**
 * User interface for displaying vehicles needing check-up.
 */
public class VehicleNeedingCheckUpUI implements Runnable {
    private final VehicleNeedingCheckUpController controller;

    /**
     * Constructs an instance of VehicleNeedingCheckUpUI.
     */
    public VehicleNeedingCheckUpUI() {
        this.controller = new VehicleNeedingCheckUpController();
    }

    /**
     * Runs the UI to display vehicles needing check-up.
     */
    @Override
    public void run() {
        printVehicles();
    }

    /**
     * Prints the list of vehicles needing check-up.
     */
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
