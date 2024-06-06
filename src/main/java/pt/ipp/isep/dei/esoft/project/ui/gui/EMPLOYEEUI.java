package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class EMPLOYEEUI {
    @FXML
    private Label welcomeLabel;
    @FXML
    private TextField nameField;
    @FXML
    private Button handleBack;


    @FXML
    public void initialize() {

    }

    @FXML
    protected void handleTaskAssignedToCollaborator(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignCollaborator = FXMLLoader.load(getClass().getResource("/TaskAssignedToCollaborator.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignCollaborator);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleCompletionTask(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent completionTask = FXMLLoader.load(getClass().getResource("/CompletionTask.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(completionTask);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack() {
        try {
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