package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillsRepository {
    private final List<Skill> skills;
    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    public void add(Skill skill) {
        skills.add(skill);
    }
}

