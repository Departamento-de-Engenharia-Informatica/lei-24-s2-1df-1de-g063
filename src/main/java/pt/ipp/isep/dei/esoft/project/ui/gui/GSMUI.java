package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GSMUI {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {

    }
    @FXML
    protected void handleAssignTeamToEntry(ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(getClass().getResource("/AssignTeamPage.fxml"));

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
    protected void handleAssignVehicleToEntry(ActionEvent event) {
        // Implement your logic here
        System.out.println("Assign Vehicle to Entry button clicked");
    }
}