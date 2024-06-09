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

/**
 * Controller class for the employee user interface.
 * Handles user interactions and navigation between screens.
 */
public class EMPLOYEEUI {
    @FXML
    private Label welcomeLabel;
    @FXML
    private TextField nameField;
    @FXML
    private Button handleBack;

    /**
     * Initializes the controller.
     * This method is automatically called after the FXML file has been loaded.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Handles the event when the user clicks on the button to handle task assignments to collaborators.
     * Loads the TaskAssignedToCollaborator.fxml file into a new stage and displays it.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    protected void handleTaskAssignedToCollaborator(ActionEvent event) {
        try {
            Parent assignCollaborator = FXMLLoader.load(getClass().getResource("/TaskAssignedToCollaborator.fxml"));
            Stage newStage = new Stage();
            Scene scene = new Scene(assignCollaborator);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the event when the user clicks on the button to complete tasks.
     * Loads the CompletionTask.fxml file into a new stage and displays it.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    protected void handleCompletionTask(ActionEvent event) {
        try {
            Parent completionTask = FXMLLoader.load(getClass().getResource("/CompletionTask.fxml"));
            Stage newStage = new Stage();
            Scene scene = new Scene(completionTask);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the event when the user clicks on the back button.
     * Loads the Login.fxml file and sets it as the scene for the current stage.
     */
    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) handleBack.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            showAlert("Error", "Failed to load the previous screen: " + e.getMessage());
        }
    }

    /**
     * Displays an alert dialog with the specified title and message.
     *
     * @param title   The title of the alert dialog.
     * @param message The message to be displayed in the alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
