package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.GreenSpaceListController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class GetManagerGreenSpaceController {

    @FXML
    private TextField nameField;

    @FXML
    private Button backButton;

    @FXML
    private Label labelGreenSpaceList;

    @FXML
    private ListView<GreenSpace> listOfGreenSpaces;

    private GreenSpaceListController controller;
    private RegisterGreenSpaceController registerController;

    @FXML
    public void initialize() {
        controller = new GreenSpaceListController();
        registerController = new RegisterGreenSpaceController();
    }

    @FXML
    public void loadGreenSpaces() {
        try {
            String name = nameField.getText();
            if (name == null || name.isEmpty()) {
                showAlert("Input Error", "Please enter a collaborator name.");
                return;
            }
            GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
            System.out.println(greenSpaceRepository.getGreenSpacesByName(name));
            listOfGreenSpaces.getItems().setAll(greenSpaceRepository.getGreenSpacesByName(name));
        } catch (Exception e) {
            showAlert("Error", "Failed to load green spaces: " + e.getMessage());
        }
    }

    @FXML
    public void goBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
