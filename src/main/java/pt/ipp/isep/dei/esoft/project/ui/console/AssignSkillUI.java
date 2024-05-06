package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignSkillUI implements Runnable {
    Scanner scan = new Scanner(System.in);

    private final AssignSkillController controller;
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;
    private int choice;
    private int userChoiceCollaborator;
    private int userChoiceSkill;

    public AssignSkillUI() {
        controller = new AssignSkillController();
        this.collaboratorRepository = CollaboratorRepository.getInstance();
        this.skillsRepository = SkillsRepository.getInstance();
    }

    private AssignSkillController getController() {
        return controller;
    }

    public void run() {
        printCollaboratorList();
        requestDataCollaborator();
        printSkillList();
        requestDataSkill();
        System.out.println("\n\n--- Assign Skill to Collaborator ------------------------");
        submitData();
    }

    private void printCollaboratorList() {
        choice = 0;
        List<Collaborator> collaborators = collaboratorRepository.getCollaborators();
        System.out.println("\n--- Collaborators List -------------------------");
        if (collaborators.isEmpty()) {
            System.out.println("No Collaborators registered yet.");
        } else {
            for (Collaborator collaborator : collaborators) {
                System.out.printf("%d - %s%n",choice,collaborator);
                choice++;
            }
        }
    }

    private void printSkillList() {
        choice = 0;
        List<Skill> skills = skillsRepository.getSkills();
        System.out.println("\n--- Skills List -------------------------");
        if (skills.isEmpty()) {
            System.out.println("No Skills registered yet.");
        } else {
            for (Skill skill : skills) {
                System.out.printf("%d - %s%n",choice,skill);
                choice++;
            }
        }
    }

    private void requestDataCollaborator(){
        userChoiceCollaborator = requestUserChoice();
    }

    private void requestDataSkill(){
        userChoiceSkill = requestUserChoice();
    }

    private int requestUserChoice(){
        int userChoice = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter your choice: ");
            String input = scan.nextLine();

            try {
                userChoice = Integer.parseInt(input);
                if (userChoice >= 0 && userChoice <= choice - 1) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and " + (choice - 1) + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return userChoice;
    }

    private void submitData() {
        Collaborator selectedCollaborator = collaboratorRepository.getCollaborators().get(userChoiceCollaborator);
        List<Skill> selectedSkills = new ArrayList<>();

        boolean continueSelectingSkills = true;

        while (continueSelectingSkills) {
            Skill selectedSkill = skillsRepository.getSkills().get(userChoiceSkill);
            selectedSkills.add(selectedSkill);

            System.out.println("Do you want to add another skill? (yes/no)");
            String input = scan.nextLine().toLowerCase();
            if (!input.equals("yes")) {
                continueSelectingSkills = false;
            } else {
                printSkillList();
                requestDataSkill();
            }
        }
        selectedCollaborator.setSkill(selectedSkills);
        System.out.println(selectedCollaborator.getSkill());
    }

}
