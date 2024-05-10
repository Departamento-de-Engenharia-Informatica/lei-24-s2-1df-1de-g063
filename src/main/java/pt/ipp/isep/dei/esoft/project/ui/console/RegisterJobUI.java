package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterJobController;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.List;
import java.util.Scanner;

public class RegisterJobUI implements Runnable {

    private final RegisterJobController controller;
    private String jobName;
    private JobRepository jobRepository;
    private Job job;

    public RegisterJobUI() {
        this.controller = new RegisterJobController();
        this.jobRepository = JobRepository.getInstance();
    }

    private RegisterJobController getController() {
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

        if (job == null || job.toString().trim().isEmpty()) {
            valid = false;
        } else if (!job.toString().matches("[a-zA-Z0-9\\s]+")) {
            System.out.println("Job has invalid characters");
            valid = false;
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
