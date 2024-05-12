package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.SkillController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SkillUI implements Runnable {

    private final SkillController controller;
    private String skillName;
    private SkillsRepository skillsRepository;
    private Skill skill;

    public SkillUI() {
        this.controller = new SkillController();
    }

    private SkillController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register skill ------------------------");

        requestData();

        submitData();

        printSkills();
    }

    private void printSkills (){
        List<Skill> skills = controller.getSkills();
        for (Skill skill : skills) {
            System.out.println(skill);
        }
    }

    private void submitData() {

        skill=controller.createSkill(skillName);
        controller.registerSkill(skill);

    }

    private void requestData() {

        skillName = requestSkillName();

    }

    private String requestSkillName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Skill name: ");
        return input.nextLine();
    }

}
