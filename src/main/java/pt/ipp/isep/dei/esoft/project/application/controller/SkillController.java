package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class SkillController {

    private SkillsRepository skillsRepository;

    public SkillController(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    private boolean validateSkill(Skill skill) {
        List<Skill> skills = skillsRepository.getSkills();
        boolean valid = true;
        for (Skill s : skills) {
            if (s.toString().equalsIgnoreCase(skill.toString())) {
                System.out.println("Skill already exists");
                valid = false;
            }else if (!skill.toString().matches("abcdefghijklmnopqrstuvwxyz")) {
                System.out.println("Insert a skill");
                valid=false;
            }else if (skill.toString().matches("%€£ºª§&+-<>/|#*$")){
                System.out.println("Skill has invalid characters");
                valid=false;
            }
        }
        return valid;
    }

    public SkillController() {
        getSkillRepository();
    }

    private SkillsRepository getSkillRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();


            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    public void registerSkill(Skill skill) {

        if (!validateSkill(skill)) {
            System.out.println("Skill has not been registered");
        } else{
            System.out.println("Skill registered successfully");
            skillsRepository.addSkill(skill);
        }

    }

    public Skill createSkill (String skillName) {

        Skill skill = new Skill(skillName);

        return skill;
    }


    public List<Skill> getSkills() {
        SkillsRepository skillRepository = getSkillRepository();
        return skillRepository.getSkills();
    }

}
