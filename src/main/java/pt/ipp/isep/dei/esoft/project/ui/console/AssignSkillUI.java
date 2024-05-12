package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User interface for assigning skills to collaborators.
 */
public class AssignSkillUI implements Runnable {

    private final Scanner scanner = new Scanner(System.in);
    private final AssignSkillController controller;
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;
    private int choice;
    private int userChoiceCollaborator;
    private int userChoiceSkill;

    /**
     * Constructs an instance of AssignSkillUI.
     */
    public AssignSkillUI() {
        controller = new AssignSkillController();
        collaboratorRepository = CollaboratorRepository.getInstance();
        skillsRepository = SkillsRepository.getInstance();
    }

    /**
     * Runs the assign skill user interface.
     */
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
                System.out.printf("%d - %s%n", choice, collaborator);
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
                System.out.printf("%d - %s%n", choice, skill);
                choice++;
            }
        }
    }

    private void requestDataCollaborator() {
        userChoiceCollaborator = requestUserChoice("collaborator");
    }

    private void requestDataSkill() {
        userChoiceSkill = requestUserChoice("skill");
    }

    private int requestUserChoice(String type) {
        int userChoice = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.printf("Enter your choice for %s: ", type);
            String input = scanner.nextLine();

            try {
                userChoice = Integer.parseInt(input);
                if (userChoice >= 0 && userChoice <= choice - 1) {
                    isValid = true;
                } else {
                    System.out.printf("Invalid choice. Please enter a number between 0 and %d.%n", choice - 1);
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
            String input = scanner.nextLine().toLowerCase();
            if (!input.equals("yes")) {
                continueSelectingSkills = false;
            } else {
                printSkillList();
                requestDataSkill();
            }
        }

        List<Skill> existingSkills = selectedCollaborator.getSkills();

        if (existingSkills != null) {
            existingSkills.addAll(selectedSkills);
        } else {
            selectedCollaborator.setSkills(selectedSkills);
        }

        System.out.println(selectedCollaborator.getSkills());
    }
}
