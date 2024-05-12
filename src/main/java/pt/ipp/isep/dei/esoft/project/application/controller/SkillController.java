package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

/**
 * The SkillController class manages the operations related to skills.
 */
public class SkillController {

    private SkillsRepository skillsRepository; // Repository for managing skills.
    private AuthenticationRepository authenticationRepository; // Repository for managing authentication.

    /**
     * Constructs a new SkillController with default repositories.
     */
    public SkillController() {
        getSkillRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new SkillController with the specified authentication repository.
     *
     * @param authenticationRepository The authentication repository to use.
     */
    public SkillController(AuthenticationRepository authenticationRepository) {
        this.skillsRepository = SkillsRepository.getInstance();
        this.authenticationRepository = new AuthenticationRepository();
    }

    /**
     * Gets the authentication repository.
     *
     * @return The authentication repository.
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Gets the skills repository.
     *
     * @return The skills repository.
     */
    public SkillsRepository getSkillRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the SkillsRepository
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    /**
     * Creates a new skill with the given name.
     *
     * @param skillName The name of the skill.
     * @return The created skill.
     */
    public Skill createSkill(String skillName) {
        Skill skill = new Skill(skillName);
        return skill;
    }

    /**
     * Retrieves all skills from the repository.
     *
     * @return A list of all skills.
     */
    public List<Skill> getSkills() {
        SkillsRepository skillRepository = getSkillRepository();
        return skillRepository.getSkills();
    }
}
