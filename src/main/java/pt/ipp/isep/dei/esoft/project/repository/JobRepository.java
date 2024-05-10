package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    private List<Job> jobs;
    private static JobRepository instance;

    public static JobRepository getInstance() {
        if (instance == null) {
            instance = new JobRepository();
        }
        return instance;
    }

    public JobRepository() {
        jobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }


    public List<Job> getJobs() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(jobs);
    }
}
