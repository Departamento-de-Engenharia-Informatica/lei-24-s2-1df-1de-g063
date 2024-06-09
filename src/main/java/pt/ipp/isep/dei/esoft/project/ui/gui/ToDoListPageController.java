package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * The ToDoListPageController class controls the UI for the ToDo list page.
 * It handles user interactions and updates the ToDo list accordingly.
 */
public class ToDoListPageController {
    @FXML
    private ListView<Entry> toDoListListView;
    private final ToDoListController toDoListController;

    @FXML
    private TextField taskField;
    @FXML
    private TextField durationField;
    @FXML
    private ChoiceBox<Urgency> selectUrgency;
    @FXML
    private ChoiceBox<GreenSpace> selectGreenSpace;
    @FXML
    private Button backButton;

    private final GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructs a ToDoListPageController object.
     * Initializes the ToDoListController and GreenSpaceRepository.
     */
    public ToDoListPageController() {
        this.toDoListController = new ToDoListController();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    }

    /**
     * Registers a new entry in the ToDo list.
     * Validates user input and adds the entry to the list.
     */
    @FXML
    protected void registerEntry() {
        // Method implementation
    }

    /**
     * Displays an alert with the given message.
     *
     * @param message The message to display in the alert.
     */
    private void showAlert(String message) {
        // Method implementation
    }

    /**
     * Initializes the ToDo list page.
     * Sets up choice boxes and populates the green space list.
     */
    @FXML
    public void initialize() {
        // Method implementation
    }

    /**
     * Handles the action when the "GO BACK" button is clicked.
     * Closes the current stage.
     *
     * @param event The action event triggered by clicking the button.
     */
    @FXML
    protected void handleGOBACK(ActionEvent event) {
        // Method implementation
    }
}
