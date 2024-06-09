package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller class for handling the registration of green spaces in the UI.
 * It manages user interactions and communicates with the domain and repository layers.
 */
public class RegisterGreenSpacePageController {
    @FXML
    private ListView<GreenSpace> greenSpaceListView;
    private final RegisterGreenSpaceController controller;

    @FXML
    private TextField nameField;
    @FXML
    private TextField managerField;
    @FXML
    private TextField areaField;
    @FXML
    private ChoiceBox<Size> selectSize;
    @FXML
    private Button backButton;

    private GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructor that initializes the controller and the green space repository.
     */
    public RegisterGreenSpacePageController() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    }

    /**
     * Handles the registration of a green space. Validates input fields and
     * displays an alert in case of invalid input.
     */
    @FXML
    protected void registerGreenSpace() {
        try {
            String name = nameField.getText();
            if (name == null || name.trim().isEmpty()) {
                showAlert("Name cannot be empty.");
                return;
            }

            if (!name.matches("[a-zA-Z- ]+")) {
                showAlert("Name can only contain letters and hyphens.");
                return;
            }

            String managerName = managerField.getText();
            if (managerName == null || managerName.trim().isEmpty()) {
                showAlert("Manager name cannot be empty.");
                return;
            }

            if (!managerName.matches("[a-zA-Z- ]+")) {
                showAlert("Manager name can only contain letters and hyphens.");
                return;
            }

            double area = Double.parseDouble(areaField.getText());
            if (area <= 0) {
                showAlert("Area must be a positive number.");
                return;
            }

            Size size = selectSize.getValue();
            if (size == null) {
                showAlert("Please select a size.");
                return;
            }

            GreenSpace greenSpace = new GreenSpace(name, area, size, managerName);
            controller.getGreenSpaceRepository().addGreenSpace(greenSpace);
            System.out.println(greenSpaceRepository.getGreenSpaces());
            greenSpaceListView.getItems().add(greenSpace);
            nameField.clear();
            areaField.clear();
            managerField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid input for area. Please enter a positive number.");
        }
    }

    /**
     * Displays an alert dialog with a specified message.
     *
     * @param message The message to be displayed in the alert dialog.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Initializes the controller. Populates the size choice box with available sizes
     * and prints the existing green spaces to the console.
     */
    @FXML
    public void initialize() {
        selectSize.getItems().setAll(Size.values());
        System.out.println("Green spaces: " + GreenSpaceRepository.getInstance().getGreenSpaces());
    }

    /**
     * Handles the action of going back to the previous scene.
     *
     * @param event The action event triggered by the user.
     */
    @FXML
    protected void handleGOBACK(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
