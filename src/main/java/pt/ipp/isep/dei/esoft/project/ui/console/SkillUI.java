package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.SkillController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.List;
import java.util.Scanner;

public class SkillUI implements Runnable {

    private final SkillController controller;
    private String skillName;
    private SkillsRepository skillsRepository;
    private Skill skill;

    public SkillUI() {
        this.controller = new SkillController();
        this.skillsRepository = SkillsRepository.getInstance();
    }

    private boolean validateSkill(Skill skill) {
        List<Skill> skills = skillsRepository.getSkills();
        boolean valid = true;
        System.out.println(skill.toString());
        if (skill.toString().matches("%€£ºª§&+-<>/|#*$")){
            System.out.println("Skill has invalid characters");
            valid=false;
        } else if (skill.toString().equalsIgnoreCase("")) {
            System.out.println("Insert a skill");
            valid=false;
        }
        for (Skill s : skills) {
            if (s.toString().equals(skill.toString())){
                System.out.println("Skill already exists");
                valid=false;
            }
        }
        return valid;
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

        if (!validateSkill(skill)) {
            System.out.println("Skill has not been registered");
        } else{
            System.out.println("Skill registered successfully");
            skillsRepository.addSkill(skill);
        }

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
