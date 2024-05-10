package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.util.List;

public class RegisterJobController {

    private JobRepository jobRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterJobController() {
        getJobRepository();
        getAuthenticationRepository();
    }

    public RegisterJobController(AuthenticationRepository authenticationRepository) {
        this.jobRepository = JobRepository.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    private JobRepository getJobRepository() {
        if (jobRepository == null) {
                Repositories repositories = Repositories.getInstance();


                jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
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
