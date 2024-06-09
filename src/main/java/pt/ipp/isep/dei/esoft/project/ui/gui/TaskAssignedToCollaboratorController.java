package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for the TaskAssignedToCollaborator user interface.
 * Handles loading and displaying assigned tasks for a collaborator.
 */
public class TaskAssignedToCollaboratorController {

    private final AgendaRepository agenda;

    @FXML
    private ListView<Entry> entryListView;

    @FXML
    private TextField nameField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextField statusField;

    private pt.ipp.isep.dei.esoft.project.application.controller.TaskAssignedToCollaboratorController controller;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * Constructs a new TaskAssignedToCollaboratorController object.
     */
    public TaskAssignedToCollaboratorController() {
        this.agenda= Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Initializes the controller.
     */
    @FXML
    public void initialize() {
        startDatePicker.setConverter(createStringConverter());
        endDatePicker.setConverter(createStringConverter());
    }

    /**
     * Loads the assigned tasks based on the provided criteria.
     */
    @FXML
    public void loadEntries() {
        try {
            String name = nameField.getText();
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();
            String status = statusField.getText();

            if (name.isEmpty() || startDate == null || endDate == null || status.isEmpty()) {
                showAlert("Input Error", "Please fill in all fields.");
                return;
            }

            controller = new pt.ipp.isep.dei.esoft.project.application.controller.TaskAssignedToCollaboratorController(name);
            List<Entry> entries = controller.getEntriesBetweenDates(startDate, endDate, status, name);

            entryListView.getItems().setAll(entries);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while loading entries.");
        }
    }

    /**
     * Closes the current window.
     */
    @FXML
    public void goBack() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

    /**
     * Creates a StringConverter for formatting LocalDate objects.
     *
     * @return A StringConverter for LocalDate objects.
     */
    private StringConverter<LocalDate> createStringConverter() {
        return new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return DATE_FORMATTER.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, DATE_FORMATTER);
                } else {
                    return null;
                }
            }
        };
    }

    /**
     * Displays an alert dialog with the given title and message.
     *
     * @param title   The title of the alert.
     * @param message The message to display in the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
