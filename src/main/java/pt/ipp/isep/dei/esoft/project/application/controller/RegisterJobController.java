package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

/**
 * The RegisterJobController class manages the registration of job roles.
 * It interacts with the JobRepository and AuthenticationRepository.
 * <p>
 * This class provides methods to access these repositories, ensuring that instances are properly initialized.
 * It is responsible for handling job role registration tasks.
 * <p>
 * Example usage:
 * <pre>{@code
 * RegisterJobController controller = new RegisterJobController();
 * JobRepository jobRepo = controller.getJobRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class RegisterJobController {

    private JobRepository jobRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a RegisterJobController object.
     * Initializes the JobRepository and AuthenticationRepository attributes.
     */
    public RegisterJobController() {
        getJobRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a RegisterJobController object with a specified authentication repository.
     * Initializes the JobRepository attribute.
     *
     * @param authenticationRepository the authentication repository
     */
    public RegisterJobController(AuthenticationRepository authenticationRepository) {
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
     * Creates a new job with the specified name.
     *
     * @param jobName the name of the job
     * @return the newly created job
     */
    public Job createJob(String jobName) {
        return new Job(jobName);
    }

    /**
     * Retrieves the list of all jobs.
     *
     * @return the list of jobs
     */
    public List<Job> getJobs() {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobs();
    }
}

