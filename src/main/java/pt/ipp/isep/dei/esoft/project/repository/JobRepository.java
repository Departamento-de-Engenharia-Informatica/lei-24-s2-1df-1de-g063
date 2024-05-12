package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * The JobRepository class manages the storage and retrieval of job information.
 * It provides methods to add and retrieve job data.
 * <p>
 * Example usage:
 * <pre>{@code
 * JobRepository jobRepo = JobRepository.getInstance();
 * jobRepo.addJob(new Job("Software Developer"));
 * }</pre>
 */
public class JobRepository {
    private List<Job> jobs;
    private static JobRepository instance;

    /**
     * Retrieves the singleton instance of JobRepository.
     *
     * @return the singleton instance of JobRepository
     */
    public static JobRepository getInstance() {
        if (instance == null) {
            instance = new JobRepository();
        }
        return instance;
    }

    /**
     * Constructs a JobRepository object.
     */
    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Adds a job to the repository.
     *
     * @param job the job to add
     */
    public void addJob(Job job) {
        jobs.add(job);
    }

    /**
     * Retrieves all jobs stored in the repository.
     *
     * @return a list of all jobs
     */
    public List<Job> getJobs() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        return new ArrayList<>(jobs);
    }
}
