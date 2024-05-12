package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

/**
 * The HrmUI class provides a user interface for HR management tasks.
 * It allows HR managers to choose from a menu of options.
 */
public class HrmUI implements Runnable {

    /**
     * Constructs a new HrmUI object.
     */
    public HrmUI() {
    }

    /**
     * Runs the HR management interface.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Add Skill", new SkillUI()));
        options.add(new MenuItem("Add Job", new RegisterJobUI()));
        options.add(new MenuItem("Register Collaborator", new RegisterCollaboratorUI()));
        options.add(new MenuItem("Assign a Skill to a Collaborator", new AssignSkillUI()));
        options.add(new MenuItem("Generate Team Proposal", new GenerateTeamUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- HRM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
