package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterJobController;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.List;

public class RegisterJobPageController {
    private final RegisterJobController controller;
    private final JobRepository jobRepository;

    @FXML
    private TextField jobNameField;

    @FXML
    private Label statusLabel;

    public RegisterJobPageController() {
        this.controller = new RegisterJobController();
        this.jobRepository = JobRepository.getInstance();
    }

    @FXML
    private void initialize() {
        // Initialization code if needed
    }

    @FXML
    private void submitData() {
        String jobName = jobNameField.getText();
        Job job = controller.createJob(jobName);

        if (!validateJob(job)) {
            statusLabel.setText("Job has not been registered");
        } else {
            statusLabel.setText("Job registered successfully");
            jobRepository.addJob(job);
        }
    }

    private boolean validateJob(Job job) {
        List<Job> jobs = jobRepository.getJobs();
        boolean valid = true;

        if (job == null || job.toString().trim().isEmpty()) {
            valid = false;
        } else if (!job.toString().matches("[a-zA-Z0-9\\s]+")) {
            statusLabel.setText("Job has invalid characters");
            valid = false;
        }

        for (Job j : jobs) {
            if (j.toString().equals(job.toString())) {
                statusLabel.setText("Job already exists");
                valid = false;
            }
        }

        return valid;
    }

    @FXML
    private void clearFields() {
        jobNameField.clear();
        statusLabel.setText("");
    }
}
