package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.io.IOException;
import java.util.Objects;

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
    private final GreenSpaceRepository greenSpaceRepository;

    public ToDoListPageController() {
        this.toDoListController = new ToDoListController();
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    @FXML
    protected void registerEntry() {
        try {
            // Get duration
            int duration = Integer.parseInt(durationField.getText());

            // Get task description
            String task = taskField.getText();

            // Get selected urgency
            Urgency urgency = selectUrgency.getValue();

            // Get selected green space
            GreenSpace greenSpace = selectGreenSpace.getValue();

            // Create a new Entry object
            Entry entry = new Entry(task, urgency, duration, greenSpace, Status.pending);

            // Register the entry using the controller
            toDoListController.registerEntry(task, urgency, duration, greenSpace, Status.pending);

            // Update the ListView
            toDoListListView.getItems().add(entry);

            // Clear input fields
            taskField.clear();
            durationField.clear();
            selectUrgency.setValue(null);
            selectGreenSpace.setValue(null);
        } catch (NumberFormatException e) {
            // Handle invalid input for duration
            System.out.println("Invalid input for duration");
        }
    }

    @FXML
    public void initialize() {
        // Initialize urgency choices
        selectUrgency.getItems().setAll(Urgency.values());

        // Initialize green space choices from the repository
        selectGreenSpace.getItems().setAll(GreenSpaceRepository.getInstance().getGreenSpaces());
    }

    @FXML
    protected void handleGOBACK (ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GSMUI.fxml")));

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
