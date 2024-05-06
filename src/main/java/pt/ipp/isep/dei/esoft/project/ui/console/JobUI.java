package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.JobController;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.List;
import java.util.Scanner;

public class JobUI implements Runnable {

    private final JobController controller;
    private String jobName;
    private JobRepository jobRepository;
    private Job job;

    public JobUI() {
        this.controller = new JobController();
        this.jobRepository = JobRepository.getInstance();
    }

    private JobController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Register Job ------------------------");

        requestData();

        submitData();

        printJobs();
    }

    private void printJobs (){
        List<Job> jobs = controller.getJobs();
        for (Job job : jobs) {
            System.out.println(job);
        }
    }

    private boolean validateJob(Job job) {
        List<Job> jobs = jobRepository.getJobs();
        boolean valid = true;
        System.out.println(job.toString());
        if (job.toString().matches("%€£ºª§&+-<>/|#*$")){
            System.out.println("Job has invalid characters");
            valid=false;
        } else if (job.toString().equalsIgnoreCase("")) {
            System.out.println("Insert a job");
            valid=false;
        }
        for (Job j : jobs) {
            if (j.toString().equals(job.toString())){
                System.out.println("Job already exists");
                valid=false;
            }
        }
        return valid;
    }

    private void submitData() {

        job=controller.createJob(jobName);
        if (!validateJob(job)) {
            System.out.println("Job has not been registered");
        } else{
            System.out.println("Job registered successfully");
            jobRepository.addJob(job);
        }

    }
    
    private void requestData() {

        jobName = requestJobName();

    }

    private String requestJobName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Job name: ");
        return input.nextLine();
    }

}
