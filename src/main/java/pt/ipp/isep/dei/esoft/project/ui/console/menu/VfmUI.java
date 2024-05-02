package pt.ipp.isep.dei.esoft.project.ui.console.menu;

//import pt.ipp.isep.dei.esoft.project.ui.console.VehicleNeedingCheckUpUI;
//import pt.ipp.isep.dei.esoft.project.ui.console.MaintenanceRegistrationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterVehicleUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class VfmUI implements Runnable {
    public VfmUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Vehicle", new RegisterVehicleUI()));
//        options.add(new MenuItem("Vehicle Maintenance Registration", new MaintenanceRegistrationUI()));
//        options.add(new MenuItem("List of Vehicle Needing Check-Up", new VehicleNeedingCheckUpUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- VEHICLE FLEET MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
