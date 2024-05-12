package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The Job class represents a job title or role in a project.
 * Each job has a unique name.
 */
public class Job {

    private final String job_name; // The name of the job.

    /**
     * Constructs a new Job with the specified name.
     *
     * @param job_name The name of the job. It cannot be changed.
     * @throws IllegalArgumentException if the job name is null.
     */
    public Job(String job_name) {
        if (job_name == null) {
            throw new IllegalArgumentException("Job name cannot be null");
        }
        this.job_name = job_name;
    }

    /**
     * Gets the name of the job.
     *
     * @return The name of the job.
     */
    public String getName() {
        return this.job_name;
    }

    /**
     * Returns a string representation of the job.
     *
     * @return A string representation of the job.
     */
    @Override
    public String toString() {
        return job_name;
    }
}
