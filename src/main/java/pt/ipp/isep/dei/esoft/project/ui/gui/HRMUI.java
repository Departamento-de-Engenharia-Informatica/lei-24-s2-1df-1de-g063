package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.isep.lei.esoft.auth.domain.model.UserRole;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.io.IOException;

public class HRMUI {
    @FXML
    private Label welcomeLabel;

    @FXML
    private Button handleBack;

    @FXML
    public void initialize() {

    }

    @FXML
    protected void handleRegisterSkillPage(ActionEvent event) {
        try {
            // Load the FXML file for the RegisterSkillPage
            Parent registerSkillPage = FXMLLoader.load(getClass().getResource("/RegisterSkillPage.fxml"));

            // Create a new stage for the RegisterSkillPage
            Stage newStage = new Stage();
            Scene scene = new Scene(registerSkillPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleRegisterJobPage(ActionEvent event) {
        try {
            // Load the FXML file for the RegisterSkillPage
            Parent registerSkillPage = FXMLLoader.load(getClass().getResource("/RegisterJobPage.fxml"));

            // Create a new stage for the RegisterSkillPage
            Stage newStage = new Stage();
            Scene scene = new Scene(registerSkillPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleRegisterCollaboratorPage(ActionEvent event) {
        try {
            // Load the FXML file for the RegisterSkillPage
            Parent registerSkillPage = FXMLLoader.load(getClass().getResource("/RegisterCollaboratorPage.fxml"));

            // Create a new stage for the RegisterSkillPage
            Stage newStage = new Stage();
            Scene scene = new Scene(registerSkillPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleAssignSkillPage(ActionEvent event) {
        try {
            // Load the FXML file for the RegisterSkillPage
            Parent registerSkillPage = FXMLLoader.load(getClass().getResource("/AssignSkillPage.fxml"));

            // Create a new stage for the RegisterSkillPage
            Stage newStage = new Stage();
            Scene scene = new Scene(registerSkillPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
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