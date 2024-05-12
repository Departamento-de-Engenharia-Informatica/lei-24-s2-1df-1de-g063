package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.SkillController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for registering skills.
 */
public class SkillUI implements Runnable {
    private final SkillController controller;
    private final SkillsRepository skillsRepository;
    private String skillName;

    /**
     * Constructs an instance of SkillUI.
     */
    public SkillUI() {
        this.controller = new SkillController();
        this.skillsRepository = SkillsRepository.getInstance();
    }

    /**
     * Runs the skill registration process.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Register Skill ------------------------");
        requestData();
        submitData();
        printSkills();
    }

    /**
     * Validates a skill.
     *
     * @param skill The skill to validate.
     * @return True if the skill is valid, otherwise false.
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
     * Retrieves the controller associated with this UI.
     *
     * @return The skill controller.
     */
    private SkillController getController() {
        return controller;
    }

    /**
     * Prints the list of registered skills.
     */
    private void printSkills (){
        List<Skill> skills = controller.getSkills();
        for (Skill skill : skills) {
            System.out.println(skill);
        }
    }

    /**
     * Submits the entered skill data.
     */
    private void submitData() {
        Skill skill = controller.createSkill(skillName);

        if (!validateSkill(skill)) {
            System.out.println("Skill has not been registered");
        } else {
            System.out.println("Skill registered successfully");
            skillsRepository.addSkill(skill);
        }
    }

    /**
     * Requests data for registering a skill.
     */
    private void requestData() {
        skillName = requestSkillName();
    }

    /**
     * Requests the name of the skill from the user.
     *
     * @return The skill name entered by the user.
     */
    private String requestSkillName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Skill name: ");
        return input.nextLine();
    }
}
