package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class CompletionTaskController {

    @FXML
    private ListView<Entry> entryListView;

    private final AgendaRepository agenda;

    private pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController controller;

    public CompletionTaskController() {
        this.agenda =  Repositories.getInstance().getAgendaRepository();;
        this.controller = new pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController();
    }

    @FXML
    public void initialize() {
        loadEntries();
        setupEntryClickHandler();
    }

    @FXML
    public void loadEntries() {
        try {
            System.out.println("Existing Entries: " + agenda.getEntries());
            entryListView.getItems().setAll(agenda.getEntries());
        } catch (IllegalArgumentException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void setupEntryClickHandler() {
        entryListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Entry selectedEntry = entryListView.getSelectionModel().getSelectedItem();
                if (selectedEntry != null) {
                    markEntryAsCompleted(selectedEntry);
                    loadEntries();  // Refresh the list view to show updated status
                }
            }
        });
    }

    private void markEntryAsCompleted(Entry entry) {
        try {
            controller.markAsCompleted(entry);
            showAlert("Success", "Entry marked as completed.");
        } catch (Exception e) {
            showAlert("Error", "Failed to mark entry as completed: " + e.getMessage());
        }
    }

    @FXML
    public void goBack() {
        Stage stage = (Stage) entryListView.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
