package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * The JobRepository class represents a repository for managing job titles or roles.
 * It provides methods to add and retrieve jobs.
 */
public class JobRepository {
    private List<Job> jobs; // List to store jobs.
    private static JobRepository instance; // Singleton instance of JobRepository.

    /**
     * Gets the singleton instance of JobRepository.
     *
     * @return The singleton instance of JobRepository.
     */
    public static JobRepository getInstance() {
        if (instance == null) {
            instance = new JobRepository();
        }
        return instance;
    }

    /**
     * Constructs a new JobRepository with an empty list of jobs.
     */
    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Adds a job to the repository.
     *
     * @param job The job to add.
     */
    public void addJob(Job job) {
        jobs.add(job);
    }

    /**
     * Retrieves all jobs from the repository.
     *
     * @return A list of all jobs.
     */
    public List<Job> getJobs() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        return new ArrayList<>(jobs);
    }
}
