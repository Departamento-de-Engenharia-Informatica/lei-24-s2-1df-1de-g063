package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;
import java.util.Optional;

public class SkillController {

    private SkillsRepository skillsRepository;

    public SkillController(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public SkillController() {
        getSkillRepository();
    }

    private SkillsRepository getSkillRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }



    public Optional<Skill> createSkill(String skillName) {

        Optional<Skill> skill = Optional.of(new Skill(skillName));

        return skill;
    }

    public List<String> getSkills() {
        SkillsRepository skillRepository = getSkillRepository();
        return skillRepository.getSkills();
    }

}
