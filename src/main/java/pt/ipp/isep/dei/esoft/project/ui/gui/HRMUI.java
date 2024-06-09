package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The HRMUI class provides a graphical user interface for Human Resource Management tasks.
 */
public class HRMUI {
    @FXML
    private Button handleBack;

    /**
     * Initializes the controller.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Handles the action to navigate to the Register Skill Page.
     *
     * @param event the action event.
     */
    @FXML
    protected void handleRegisterSkillPage(ActionEvent event) {
        loadFXML("/RegisterSkillPage.fxml");
    }

    /**
     * Handles the action to navigate to the Register Job Page.
     *
     * @param event the action event.
     */
    @FXML
    protected void handleRegisterJobPage(ActionEvent event) {
        loadFXML("/RegisterJobPage.fxml");
    }

    /**
     * Handles the action to navigate to the Register Collaborator Page.
     *
     * @param event the action event.
     */
    @FXML
    protected void handleRegisterCollaboratorPage(ActionEvent event) {
        loadFXML("/RegisterCollaboratorPage.fxml");
    }

    /**
     * Handles the action to navigate to the Assign Skill Page.
     *
     * @param event the action event.
     */
    @FXML
    protected void handleAssignSkillPage(ActionEvent event) {
        loadFXML("/AssignSkillPage.fxml");
    }

    /**
     * Handles the action to navigate to the Generate Team Page.
     *
     * @param event the action event.
     */
    @FXML
    protected void handleGenerateTeamPageController(ActionEvent event) {
        loadFXML("/AssignSkillPage.fxml");
    }

    /**
     * Handles the action to go back to the previous screen.
     */
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

    /**
     * Loads the specified FXML file.
     *
     * @param fxmlPath the path to the FXML file.
     */
    private void loadFXML(String fxmlPath) {
        try {
            // Load the FXML file
            Parent registerPage = FXMLLoader.load(getClass().getResource(fxmlPath));

            // Create a new stage for the FXML file
            Stage newStage = new Stage();
            Scene scene = new Scene(registerPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            showAlert("Error", "Failed to load the page: " + e.getMessage());
        }
    }

    /**
     * Displays an alert dialog with the given title and message.
     *
     * @param title   the title of the alert dialog.
     * @param message the message to display.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
