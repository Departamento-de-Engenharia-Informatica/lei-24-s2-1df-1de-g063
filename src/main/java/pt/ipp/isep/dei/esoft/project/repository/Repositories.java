package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;

/**
 * The Repositories class provides access to various repositories used in the application.
 * It manages the creation and retrieval of repository instances.
 */
public class Repositories {

    private static Repositories instance; // Singleton instance of Repositories.
    private final OrganizationRepository organizationRepository; // Repository for managing organizations.
    private final TaskCategoryRepository taskCategoryRepository; // Repository for managing task categories.
    private final AuthenticationRepository authenticationRepository; // Repository for managing authentication.
    private final SkillsRepository skillsRepository; // Repository for managing skills.
    private final JobRepository jobRepository; // Repository for managing jobs.
    private final CollaboratorRepository collaboratorRepository; // Repository for managing collaborators.
    private final VehicleRepository vehicleRepository; // Repository for managing vehicles.

    /**
     * Constructs a new Repositories with instances of all repositories.
     */
    private Repositories() {
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        skillsRepository = new SkillsRepository();
        jobRepository = new JobRepository();
        collaboratorRepository = new CollaboratorRepository();
        vehicleRepository = new VehicleRepository();
    }

    /**
     * Gets the singleton instance of Repositories.
     *
     * @return The singleton instance of Repositories.
     */
    public static Repositories getInstance() {
        if (instance == null) {
            instance = new Repositories();
        }
        return instance;
    }

    /**
     * Gets the organization repository.
     *
     * @return The organization repository.
     */
    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    /**
     * Gets the task category repository.
     *
     * @return The task category repository.
     */
    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    /**
     * Gets the collaborator repository.
     *
     * @return The collaborator repository.
     */
    public CollaboratorRepository getCollaboratorRepository() {
        return CollaboratorRepository.getInstance();
    }

    /**
     * Gets the skills repository.
     *
     * @return The skills repository.
     */
    public SkillsRepository getSkillsRepository() {
        return SkillsRepository.getInstance();
    }

    /**
     * Gets the job repository.
     *
     * @return The job repository.
     */
    public JobRepository getJobRepository() {
        return JobRepository.getInstance();
    }

    /**
     * Gets the authentication repository.
     *
     * @return The authentication repository.
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    /**
     * Gets the vehicle repository.
     *
     * @return The vehicle repository.
     */
    public VehicleRepository getVehicleRepository() {
        return VehicleRepository.getInstance();
    }
}
