package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller class for handling the to-do list entries in the UI.
 * It manages user interactions and communicates with the domain and repository layers.
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
     * Constructor that initializes the controller and the green space repository.
     */
    public ToDoListPageController() {
        this.toDoListController = new ToDoListController();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository(); // Use the singleton instance
    }

    /**
     * Handles the registration of a to-do list entry. Validates input fields and
     * displays an alert in case of invalid input.
     */
    @FXML
    protected void registerEntry() {
        try {
            String task = taskField.getText();
            if (task == null || task.trim().isEmpty()) {
                showAlert("Task description cannot be empty.");
                return;
            }

            if (!task.matches("[a-zA-Z ]+")) {
                showAlert("Task description can only contain letters.");
                return;
            }

            int duration = Integer.parseInt(durationField.getText());
            if (duration <= 0) {
                showAlert("Duration must be a positive number.");
                return;
            }

            Urgency urgency = selectUrgency.getValue();
            if (urgency == null) {
                showAlert("Please select an urgency level.");
                return;
            }

            GreenSpace greenSpace = selectGreenSpace.getValue();
            if (greenSpace == null) {
                showAlert("Please select a green space.");
                return;
            }

            Entry entry = new Entry(task, urgency, duration, greenSpace, Status.pending);
            toDoListController.registerEntry(task, urgency, duration, greenSpace, Status.pending);
            toDoListListView.getItems().add(entry);
            toDoListController.getToDoList().addEntry(entry);
            taskField.clear();
            durationField.clear();
            selectUrgency.setValue(null);
            selectGreenSpace.setValue(null);
        } catch (NumberFormatException e) {
            showAlert("Invalid input for duration. Please enter a positive number.");
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
     * Initializes the controller. Populates the urgency and green space choice boxes
     * with available values and prints the existing green spaces to the console.
     */
    @FXML
    public void initialize() {
        selectUrgency.getItems().setAll(Urgency.values());
        selectGreenSpace.getItems().clear();
        selectGreenSpace.getItems().setAll(greenSpaceRepository.getGreenSpaces()); // Use the singleton instance
        System.out.println("Green spaces: " + greenSpaceRepository.getGreenSpaces());
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
