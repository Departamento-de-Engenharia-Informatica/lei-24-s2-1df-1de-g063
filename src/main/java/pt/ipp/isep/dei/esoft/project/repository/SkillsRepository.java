package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillsRepository {
    private static SkillsRepository instance;
    private List<Skill> skills;

    public static SkillsRepository getInstance() {
        if (instance == null) {
            instance = new SkillsRepository();
        }
        return instance;
    }

    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public Skill getSkillByName(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                return skill;
            }
        }
        // Return null if no skill with the given name is found
        return null;
    }


    public List<Skill> getSkills() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(skills);
    }

}

