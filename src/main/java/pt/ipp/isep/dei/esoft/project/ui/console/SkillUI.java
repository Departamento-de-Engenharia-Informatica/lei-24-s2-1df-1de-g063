package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.SkillController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.List;
import java.util.Scanner;

/**
 * The SkillUI class represents the user interface for managing skills through the console.
 * It allows users to register and display skills.
 */
public class SkillUI implements Runnable {

    private final SkillController controller; // Controller for managing skills.
    private String skillName; // Name of the skill being registered.
    private final SkillsRepository skillsRepository; // Repository for managing skills.

    /**
     * Constructs a new SkillUI with default controller and repository instances.
     */
    public SkillUI() {
        this.controller = new SkillController();
        this.skillsRepository = SkillsRepository.getInstance();
    }

    /**
     * Validates a skill.
     *
     * @param skill The skill to validate.
     * @return True if the skill is valid, false otherwise.
     */
    private boolean validateSkill(Skill skill) {
        List<Skill> skills = skillsRepository.getSkills();
        boolean valid = true;

        if (skill == null || skill.toString().trim().isEmpty()) {
            valid = false;
        } else if (!skill.toString().matches("[a-zA-Z0-9\\s]+")) {
            System.out.println("Skill has invalid characters");
            valid = false;
        }
        for (Skill s : skills) {
            if (s.toString().equals(skill.toString())){
                System.out.println("Skill already exists");
                valid=false;
            }
        }

        return valid;
    }

    /**
     * Gets the controller for managing skills.
     *
     * @return The SkillController instance.
     */
    private SkillController getController() {
        return controller;
    }

    /**
     * Runs the SkillUI.
     */
    public void run() {
        System.out.println("\n\n--- Register skill ------------------------");

        requestData();

        submitData();

        printSkills();
    }

    /**
     * Prints all registered skills.
     */
    private void printSkills (){
        List<Skill> skills = controller.getSkills();
        for (Skill skill : skills) {
            System.out.println(skill);
        }
    }

    /**
     * Submits the entered data for skill registration.
     */
    private void submitData() {
        Skill skill = controller.createSkill(skillName);

        if (!validateSkill(skill)) {
            System.out.println("Skill has not been registered");
        } else{
            System.out.println("Skill registered successfully");
            skillsRepository.addSkill(skill);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        skillName = requestSkillName();
    }

    /**
     * Requests the name of the skill from the user.
     *
     * @return The name of the skill entered by the user.
     */
    private String requestSkillName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Skill name: ");
        return input.nextLine();
    }
}
