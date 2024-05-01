package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillsRepository {
    private List<String> skills;
    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public Optional<Skill> add(Skill skill) {

        Optional<Skill> newSkill = Optional.empty();
        boolean operationSuccess = false;

        if (validateSkill(skill)) {
            newSkill = Optional.of(skill.clone());
            operationSuccess = skills.add(newSkill.get().toString());
        }

        if (!operationSuccess) {
            newSkill = Optional.empty();
        }

        return newSkill;
    }

    private boolean validateSkill(Skill skill) {
        boolean isValid = !skills.contains(skill);
        return isValid;
    }
    public List<String> getSkills() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(skills);
    }

}

