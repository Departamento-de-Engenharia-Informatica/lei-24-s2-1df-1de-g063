package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.SkillController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.io.IOException;
import java.util.List;

public class RegisterSkillPageController {
    private SkillController controller;
    private SkillsRepository skillsRepository;

    @FXML
    private Button handleBack;
    @FXML
    private TextField skillNameField;
    @FXML
    private ListView<String> skillListView;
    @FXML
    private Label statusLabel;
    @FXML
    private Button submitButton;

    // No-argument constructor
    public RegisterSkillPageController() {
        controller = new SkillController();
        skillsRepository = SkillsRepository.getInstance();
    }

    @FXML
    private void initialize() {
        printSkills();
    }

    @FXML
    private void submitData() {
        String skillName = skillNameField.getText();
        Skill skill = controller.createSkill(skillName);

        if (!validateSkill(skill)) {
            statusLabel.setText("Skill has not been registered");
        } else {
            statusLabel.setText("Skill registered successfully");
            skillsRepository.addSkill(skill);
            skillNameField.clear();
            printSkills();
        }
    }

    private boolean validateSkill(Skill skill) {
        List<Skill> skills = skillsRepository.getSkills();
        boolean valid = true;

        if (skill == null || skill.toString().trim().isEmpty()) {
            valid = false;
        } else if (!skill.toString().matches("[a-zA-Z0-9\\s]+")) {
            statusLabel.setText("Skill has invalid characters");
            valid = false;
        }
        for (Skill s : skills) {
            if (s.toString().equals(skill.toString())) {
                statusLabel.setText("Skill already exists");
                valid = false;
            }
        }

        return valid;
    }

    private void printSkills() {
        List<Skill> skills = controller.getSkills();
        skillListView.getItems().clear();
        for (Skill skill : skills) {
            skillListView.getItems().add(skill.toString());
        }
    }

    @FXML
    private void handleBack() {
        try{
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) handleBack.getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            showAlert("Error", "Failed to load the previous screen: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
