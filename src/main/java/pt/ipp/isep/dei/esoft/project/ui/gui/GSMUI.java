package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The GSMUI class is responsible for the user interface that allows
 * the user to navigate through different functionalities of the system.
 */
public class GSMUI {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button handleBack;

    /**
     * Initializes the GSMUI.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Handles the action of assigning a team to an entry.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleAssignTeamToEntry(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/AssignTeamPage.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignTeamPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of assigning a vehicle to an entry.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleAssignVehicleToEntry(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/AssignVehiclePage.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignTeamPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Handles the action of registering a green space.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleRegisterGreenSpacePageController (ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/RegisterGreenSpacePage.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignTeamPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Handles the action of opening the agenda page.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleAgendaPageController(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/Agenda.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the AssignTeamPage
            Scene scene = new Scene(assignTeamPage);

            // Set the scene of the current stage to the new scene
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of opening the to-do list page.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleToDoListPageController(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/ToDoListPageController.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignTeamPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of getting the manager of a green space.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleGetManagerGreenSpaceController(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/GetManagerGreenSpaceController.fxml"));

            // Create a new stage for the AssignTeamPage
            Stage newStage = new Stage();
            Scene scene = new Scene(assignTeamPage);
            newStage.setScene(scene);
            newStage.show(); // Show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of going back to the previous page.
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
     * Shows an alert with a given title and message.
     * @param title The title of the alert.
     * @param message The message of the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the action of postponing an entry.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handlePostponeEntryPageController(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/PostponeEntryPage.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the AssignTeamPage
            Scene scene = new Scene(assignTeamPage);

            // Set the scene of the current stage to the new scene
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of cancelling an entry.
     * @param event The event that triggers this action.
     */
    @FXML
    protected void handleCancelEntryPageController(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/CancelEntryPage.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the AssignTeamPage
            Scene scene = new Scene(assignTeamPage);

            // Set the scene of the current stage to the new scene
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}