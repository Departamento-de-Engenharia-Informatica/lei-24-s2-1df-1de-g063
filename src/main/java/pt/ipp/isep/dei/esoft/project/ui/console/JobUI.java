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

    private void submitData() {

        job=controller.createJob(jobName);
        controller.registerJob(job);

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
