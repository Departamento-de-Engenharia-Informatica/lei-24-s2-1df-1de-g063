package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterCollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegisterCollaboratorPageController {
    private final RegisterCollaboratorController controller;
    private final CollaboratorRepository collaboratorRepository;
    private final JobRepository jobRepository;

    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private ComboBox<String> idTypeComboBox;

    @FXML
    private TextField idNumberField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private DatePicker admissionDatePicker;

    @FXML
    private ComboBox<String> jobComboBox;

    @FXML
    private Label statusLabel;

    public RegisterCollaboratorPageController() {
        this.controller = new RegisterCollaboratorController();
        this.collaboratorRepository = CollaboratorRepository.getInstance();
        this.jobRepository = JobRepository.getInstance();
    }

    @FXML
    private void initialize() {
        idTypeComboBox.getItems().addAll("Cartão de cidadão", "Passaporte");
        loadJobs();
    }

    private void loadJobs() {
        List<Job> jobs = jobRepository.getJobs();
        for (Job job : jobs) {
            jobComboBox.getItems().add(job.toString());
        }
    }

    @FXML
    private void submitData() {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String idType = idTypeComboBox.getValue();
        String idNumber = idNumberField.getText();
        LocalDate birthDate = birthDatePicker.getValue();
        LocalDate admissionDate = admissionDatePicker.getValue();
        String job = jobComboBox.getValue();

        Collaborator collaborator = controller.registerCollaborator(name, address, email, phoneNumber, idType, idNumber, birthDate, admissionDate, job);
        collaboratorRepository.addCollaborator(collaborator);

        statusLabel.setText("Collaborator registered successfully");
        clearFields();
    }

    @FXML
    private void clearFields() {
        nameField.clear();
        addressField.clear();
        emailField.clear();
        phoneNumberField.clear();
        idTypeComboBox.getSelectionModel().clearSelection();
        idNumberField.clear();
        birthDatePicker.getEditor().clear();
        admissionDatePicker.getEditor().clear();
        jobComboBox.getSelectionModel().clearSelection();
        statusLabel.setText("");
    }
}
