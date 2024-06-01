package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The GsmUI class provides a user interface for GSM management tasks.
 * It allows GSM managers to choose from a menu of options.
 */
public class CollaboratorUI implements Runnable {
    private final String email;

    /**
     * Constructs a new GsmUI object with the specified email.
     *
     * @param email The email address of the user.
     */
    public CollaboratorUI(String email) {
        this.email = email;
    }

    /**
     * Runs the GSM management interface.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
//        options.add(new MenuItem("Tasks assigned to the collaborator", new TaskAssignedToCollaboratorUI(email)));
        options.add(new MenuItem("Record the completion of a task", new ToDoListUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GSM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
