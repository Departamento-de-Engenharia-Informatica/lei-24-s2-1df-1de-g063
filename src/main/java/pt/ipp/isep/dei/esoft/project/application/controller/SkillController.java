package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

public class SkillController {

    private SkillsRepository skillsRepository;

    public boolean addSkill(String skill) {
        try {
            Skill skill1 = new Skill(skill);
            skillsRepository.add(skill1);
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
}
