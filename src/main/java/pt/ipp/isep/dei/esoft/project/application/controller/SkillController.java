package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

public class SkillController {

    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;

    public SkillController() {
        getSkillRepository();
        getAuthenticationRepository();
    }

    public SkillController(AuthenticationRepository authenticationRepository) {
        this.skillsRepository = SkillsRepository.getInstance();
        this.authenticationRepository = new AuthenticationRepository();
    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public SkillsRepository getSkillRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();


            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
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
