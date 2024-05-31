package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The GsmUI class provides a user interface for GSM management tasks.
 * It allows GSM managers to choose from a menu of options.
 */
public class GsmUI implements Runnable {
    private final String email;

    /**
     * Constructs a new GsmUI object with the specified email.
     *
     * @param email The email address of the user.
     */
    public GsmUI(String email) {
        this.email = email;
    }

    /**
     * Runs the GSM management interface.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register Green Space", new RegisterGreenSpaceUI(email)));
        options.add(new MenuItem("Add entry to To-Do List", new ToDoListUI()));
        options.add(new MenuItem("Add entry to Agenda", new AgendaUI()));
        options.add(new MenuItem("Cancel Entry", new CancelEntryUI()));
        options.add(new MenuItem("Assign a Team to an Entry in the Agenda", new AssignTeamToEntryUI()));
        options.add(new MenuItem("Assign a Vehicle to an Entry in the Agenda", new AssignVehicleToEntryUI()));
        options.add(new MenuItem("Green Spaces Managed by me", new GreenSpacesListUI(email))); // Added menu item

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GSM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
