package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

/**
 * The AssignSkillController class handles the assignment of skills to collaborators.
 * It interacts with the CollaboratorRepository, SkillsRepository, and AuthenticationRepository.
 * <p>
 * The class provides methods to retrieve instances of the CollaboratorRepository, SkillsRepository,
 * and AuthenticationRepository if they are not already initialized.
 * <p>
 * Example usage:
 * <pre>{@code
 * AssignSkillController controller = new AssignSkillController();
 * CollaboratorRepository collaboratorRepo = controller.getCollaboratorRepository();
 * SkillsRepository skillsRepo = controller.getSkillsRepository();
 * }</pre>
 */
public class AssignSkillController {
    private CollaboratorRepository collaboratorRepository;
    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs an AssignSkillController object.
     * Initializes the CollaboratorRepository, SkillsRepository, and AuthenticationRepository attributes.
     */
    public AssignSkillController(){
        getCollaboratorRepository();
        getSkillsRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs an AssignSkillController object with a specified AuthenticationRepository.
     * Initializes the CollaboratorRepository attribute.
     *
     * @param authenticationRepository the AuthenticationRepository to use
     */
    public AssignSkillController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
        this.collaboratorRepository = CollaboratorRepository.getInstance();
    }

    /**
     * Retrieves the CollaboratorRepository instance.
     * If the instance is not initialized, initializes it using Repositories.getInstance().
     *
     * @return the CollaboratorRepository instance
     */
    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Retrieves the SkillsRepository instance.
     * If the instance is not initialized, initializes it using Repositories.getInstance().
     *
     * @return the SkillsRepository instance
     */
    public SkillsRepository getSkillsRepository() {
        if(skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    /**
     * Retrieves the AuthenticationRepository instance.
     * If the instance is not initialized, initializes it using Repositories.getInstance().
     *
     * @return the AuthenticationRepository instance
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
}
