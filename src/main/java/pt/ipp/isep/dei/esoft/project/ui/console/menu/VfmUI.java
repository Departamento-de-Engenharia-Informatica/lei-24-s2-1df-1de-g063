package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.MaintenanceRegistrationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterVehicleUI;
import pt.ipp.isep.dei.esoft.project.ui.console.VehicleNeedingCheckUpUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the user interface for the Vehicle Fleet Manager (VFM) role.
 */
public class VfmUI implements Runnable {

    /**
     * Constructs a new VfmUI instance.
     */
    public VfmUI() {
    }

    /**
     * Runs the VFM user interface, providing options for managing vehicles.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();

        // Add menu options for VFM role
        options.add(new MenuItem("Register Vehicle", new RegisterVehicleUI()));
        options.add(new MenuItem("Vehicle Maintenance Registration", new MaintenanceRegistrationUI()));
        options.add(new MenuItem("List of Vehicles Needing Check-Up", new VehicleNeedingCheckUpUI()));

        int option = 0;
        do {
            // Display menu and get user input
            option = Utils.showAndSelectIndex(options, "\n\n--- VEHICLE FLEET MANAGER MENU -------------------------");

            // Execute the selected menu option
            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
