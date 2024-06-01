package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;


import java.time.LocalDate;

/**
 * The RegisterCollaboratorController class manages the registration of collaborators.
 * It interacts with the JobRepository, CollaboratorRepository, and AuthenticationRepository.
 * <p>
 * This class provides methods to access these repositories, ensuring that instances are properly initialized.
 * It is responsible for handling collaborator registration tasks.
 * <p>
 * Example usage:
 * <pre>{@code
 * RegisterCollaboratorController controller = new RegisterCollaboratorController();
 * JobRepository jobRepo = controller.getJobRepository();
 * CollaboratorRepository collabRepo = controller.getCollaboratorRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class RegisterCollaboratorController {
    private JobRepository jobRepository;
    private CollaboratorRepository collaboratorRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a RegisterCollaboratorController object.
     * Initializes the JobRepository, CollaboratorRepository, and AuthenticationRepository attributes.
     */
    public RegisterCollaboratorController() {
        getJobRepository();
        getAuthenticationRepository();
        getCollaboratorRepository();
    }

    /**
     * Constructs a RegisterCollaboratorController object with a specified authentication repository.
     * Initializes the JobRepository attribute.
     *
     * @param authenticationRepository the authentication repository
     */
    public RegisterCollaboratorController(AuthenticationRepository authenticationRepository) {
        this.jobRepository = JobRepository.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the job repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the job repository
     */
    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    /**
     * Retrieves the collaborator repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the collaborator repository
     */
    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Retrieves the authentication repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the authentication repository
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Registers a new collaborator with the specified details.
     *
     * @param name         the name of the collaborator
     * @param address      the address of the collaborator
     * @param email        the email of the collaborator
     * @param phoneNumber  the phone number of the collaborator
     * @param idType       the type of ID of the collaborator
     * @param idNumber     the ID number of the collaborator
     * @param birthDate    the birth date of the collaborator
     * @param admissionDate the admission date of the collaborator
     * @param job          the job role of the collaborator
     * @return the newly registered collaborator
     */
    public Collaborator registerCollaborator(String name, String address, String email, String phoneNumber,
                                             String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate,
                                             String job) {
        return new Collaborator(name, address, email, phoneNumber, idType, idNumber, birthDate, admissionDate, job);
    }
}

