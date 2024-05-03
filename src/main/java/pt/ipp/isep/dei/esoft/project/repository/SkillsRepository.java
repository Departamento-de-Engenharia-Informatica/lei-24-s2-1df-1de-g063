package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillsRepository {

    private List<Skill> skills;


    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

//    public List<Skill> add(Skill skill) {
//        List<Skill> newSkill;
//        if (skills.contains(skill)) {
//            throw new IllegalArgumentException("Skill already exists.");
//        }
//
//        skills.add(skill);
//
//        return newSkill;
//    }


    public List<Skill> getSkills() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(skills);
    }

}

