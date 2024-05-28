package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.ToDoListUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterGreenSpaceUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GsmUI implements Runnable {

    /**
     * Constructs a new HrmUI object.
     */
    public GsmUI() {
    }

    /**
     * Runs the HR management interface.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register Green Space", new RegisterGreenSpaceUI()));
        options.add(new MenuItem("Add entry to To-Do List", new ToDoListUI()));
        //options.add(new MenuItem("Add entry to Agenda", new AddEntryAgendaUI()));
        //options.add(new MenuItem("Assign a Team to an Entry in the Agenda", new AssignTeamToEntryUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GSM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
