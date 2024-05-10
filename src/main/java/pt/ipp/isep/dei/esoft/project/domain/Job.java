package pt.ipp.isep.dei.esoft.project.domain;

public class Job {

    private final String job_name;

    public Job(String job_name) {
        this.job_name = job_name;
    }

    public String getName() {
        return this.job_name;
    }

    @Override
    public String toString() {
        if (this.job_name != null) {
            return job_name ;
        }else{
            return "";
        }
    }
}
