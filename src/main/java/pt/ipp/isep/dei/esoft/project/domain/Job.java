package pt.ipp.isep.dei.esoft.project.domain;

public class Job {

    private final String job_name;

    public Job(String job_name) {
        if (job_name == null) {
            throw new IllegalArgumentException("Job name cannot be null");
        }
        this.job_name = job_name;
    }

    public String getName() {
        return this.job_name;
    }

    public Job clone() {
        return new Job(this.job_name);
    }

    @Override
    public String toString() {
        return job_name ;
    }
}
