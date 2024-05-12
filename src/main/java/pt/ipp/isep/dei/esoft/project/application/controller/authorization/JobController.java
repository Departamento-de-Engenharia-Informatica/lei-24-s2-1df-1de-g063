package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class JobController {

    private JobRepository jobRepository;

    public JobController (JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private boolean validateJob(Job job) {
        List<Job> jobs = jobRepository.getJobs();
        boolean valid = true;
        for (Job j : jobs) {
            if (j.toString().equalsIgnoreCase(job.toString())){
                System.out.println("Job already exists");
                valid=false;
            } else if (job.toString().matches("abcdefghijklmnopqrstuvwxyz")) {
                System.out.println("Insert a job");
                valid=false;
            }
            else if (job.toString().matches("%€£ºª§&+-<>/|#*$")) {
                System.out.println("Job has invalid characters");
                valid = false;
            }
        }
        return valid;
    }

    public JobController() {
        getJobRepository();
    }

    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();


            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    public void registerJob(Job job) {

        if (!validateJob(job)) {
            System.out.println("Job has not been registered");
        } else{
            System.out.println("Job registered successfully");
            jobRepository.addJob(job);
        }

    }

    public Job createJob (String jobName) {

        Job job = new Job(jobName);

        return job;
    }


    public List<Job> getJobs() {
        JobRepository jobRepository = getJobRepository();
        return jobRepository.getJobs();
    }

}
