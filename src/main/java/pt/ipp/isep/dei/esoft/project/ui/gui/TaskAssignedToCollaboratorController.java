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

    public TaskAssignedToCollaboratorController() {
        this.agenda= Repositories.getInstance().getAgendaRepository();
    }

    @FXML
    public void initialize() {
        startDatePicker.setConverter(createStringConverter());
        endDatePicker.setConverter(createStringConverter());
    }

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

            System.out.println("Fetching entries for:");
            System.out.println("Collaborator: " + name);
            System.out.println("Start Date: " + startDate.format(DATE_FORMATTER));
            System.out.println("End Date: " + endDate.format(DATE_FORMATTER));
            System.out.println("Status: " + status);

            controller = new pt.ipp.isep.dei.esoft.project.application.controller.TaskAssignedToCollaboratorController(name);
            List<Entry> entries = controller.getEntriesBetweenDates(startDate, endDate, status, name);

            System.out.println("Entries fetched: " + entries.size());
            System.out.println("Existing Entries: " + agenda.getEntries());
            for (Entry entry : entries) {
                System.out.println(entry);
            }

            entryListView.getItems().setAll(entries);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while loading entries.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void goBack() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

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
}
