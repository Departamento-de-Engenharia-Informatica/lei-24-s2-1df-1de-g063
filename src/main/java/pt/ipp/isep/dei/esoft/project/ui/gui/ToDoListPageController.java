package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

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
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository(); // Use the singleton instance
    }

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
            taskField.clear();
            durationField.clear();
            selectUrgency.setValue(null);
            selectGreenSpace.setValue(null);
        } catch (NumberFormatException e) {
            showAlert("Invalid input for duration. Please enter a positive number.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        selectUrgency.getItems().setAll(Urgency.values());
        selectGreenSpace.getItems().clear();
        selectGreenSpace.getItems().setAll(greenSpaceRepository.getGreenSpaces()); // Use the singleton instance
        System.out.println("Green spaces: " + greenSpaceRepository.getGreenSpaces());
    }
    @FXML
    protected void handleGOBACK (ActionEvent event) {
        try{
            Parent assignTeamPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GSMUI.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(assignTeamPage);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
