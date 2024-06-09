package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * Controller class for the Register Green Space Page UI.
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
     * Constructs a new RegisterGreenSpacePageController.
     */
    public RegisterGreenSpacePageController() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    }

    /**
     * Registers a new green space.
     */
    @FXML
    protected void registerGreenSpace() {
        // Method implementation
    }

    /**
     * Displays an alert with the given message.
     *
     * @param message the message to display
     */
    private void showAlert(String message) {
        // Method implementation
    }

    /**
     * Initializes the controller.
     */
    @FXML
    public void initialize() {
        // Method implementation
    }

    /**
     * Handles the action event to go back.
     *
     * @param event the action event
     */
    @FXML
    protected void handleGOBACK(ActionEvent event) {
        // Method implementation
    }
}
