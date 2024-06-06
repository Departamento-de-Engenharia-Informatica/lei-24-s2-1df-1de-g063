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

public class GSMUI {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button handleBack;

    @FXML
    public void initialize() {

    }
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
    @FXML
    protected void handleRegisterGreenSpacePageController(ActionEvent event) {
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