package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The Job class represents a job within the system.
 * It encapsulates the job name.
 * <p>
 * Example usage:
 * <pre>{@code
 * Job job = new Job("Software Developer");
 * String jobName = job.getName();
 * }</pre>
 */
public class Job {

    private final String job_name;

    /**
     * Constructs a Job object with the specified job name.
     *
     * @param job_name the name of the job
     * @throws IllegalArgumentException if the job name is null
     */
    public Job(String job_name) {
        if (job_name == null) {
            throw new IllegalArgumentException("Job name cannot be null");
        }
        this.job_name = job_name;
    }

    /**
     * Retrieves the name of the job.
     *
     * @return the name of the job
     */
    public String getName() {
        return this.job_name;
    }

    /**
     * Returns a string representation of the job.
     *
     * @return a string representation of the job
     */
    @Override
    public String toString() {
        return job_name;
    }
}
