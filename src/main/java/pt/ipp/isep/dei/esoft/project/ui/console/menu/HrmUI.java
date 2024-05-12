package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class HrmUI implements Runnable {
    public HrmUI() {
    }


    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
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