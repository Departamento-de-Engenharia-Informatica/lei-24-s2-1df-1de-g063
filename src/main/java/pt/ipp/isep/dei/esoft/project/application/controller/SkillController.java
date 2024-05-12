package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

/**
 * The SkillController class manages skills and their registration.
 * It interacts with the SkillsRepository and AuthenticationRepository.
 * <p>
 * This class provides methods to access these repositories, ensuring that instances are properly initialized.
 * It is responsible for handling skill registration tasks.
 * <p>
 * Example usage:
 * <pre>{@code
 * SkillController controller = new SkillController();
 * SkillsRepository skillRepo = controller.getSkillRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class SkillController {

    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a SkillController object.
     * Initializes the SkillsRepository and AuthenticationRepository attributes.
     */
    public SkillController() {
        getSkillRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a SkillController object with a specified authentication repository.
     *
     * @param authenticationRepository the authentication repository
     */
    public SkillController(AuthenticationRepository authenticationRepository) {
        this.skillsRepository = SkillsRepository.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the authentication repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Retrieves the skill repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the skill repository
     */
    public SkillsRepository getSkillRepository() {
        if (skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    /**
     * Creates a new skill with the specified name.
     *
     * @param skillName the name of the skill
     * @return the newly created skill
     */
    public Skill createSkill(String skillName) {
        return new Skill(skillName);
    }

    /**
     * Retrieves the list of skills from the skill repository.
     *
     * @return the list of skills
     */
    public List<Skill> getSkills() {
        SkillsRepository skillRepository = getSkillRepository();
        return skillRepository.getSkills();
    }
}
