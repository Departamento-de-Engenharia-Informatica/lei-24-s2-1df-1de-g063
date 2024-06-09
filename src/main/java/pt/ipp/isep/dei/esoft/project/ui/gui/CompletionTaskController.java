package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * This class provides a graphical user interface for marking an entry as completed.
 * It allows the user to view the list of entries, select an entry, and mark the selected entry as completed.
 * The class uses a CompletionTaskController to handle the business logic of marking the entry as completed.
 * It also uses an AgendaRepository to manage the entries in the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the list of entries.
 * It also includes several FXML-annotated instance variables for interacting with the user interface, including a ListView for displaying the entries, and an AgendaRepository for managing the entries.
 * The class includes a main method, initialize(), which is called when the class is instantiated.
 * This method loads the entries into the ListView and sets up the entry click handler.
 * The class includes several private methods for handling user actions, including marking an entry as completed, loading the entries, setting up the entry click handler, going back to the previous page, and showing an alert.
 */
public class CompletionTaskController {

    @FXML
    private ListView<Entry> entryListView;

    private final AgendaRepository agenda;

    private pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController controller;

    /**
     * Constructs a new CompletionTaskController.
     */
    public CompletionTaskController() {
        this.agenda =  Repositories.getInstance().getAgendaRepository();;
        this.controller = new pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController();
    }

    /**
     * Initializes the controller, loads the entries into the ListView, and sets up the entry click handler.
     */
    @FXML
    public void initialize() {
        loadEntries();
        setupEntryClickHandler();
    }

    /**
     * Loads the entries into the ListView.
     */
    @FXML
    public void loadEntries() {
        try {
            System.out.println("Existing Entries: " + agenda.getEntries());
            entryListView.getItems().setAll(agenda.getEntries());
        } catch (IllegalArgumentException e) {
            showAlert("Error", e.getMessage());
        }
    }

    /**
     * Sets up the entry click handler.
     */
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

    /**
     * Marks an entry as completed.
     *
     * @param entry The entry to be marked as completed.
     */
    private void markEntryAsCompleted(Entry entry) {
        try {
            controller.markAsCompleted(entry);
            showAlert("Success", "Entry marked as completed.");
        } catch (Exception e) {
            showAlert("Error", "Failed to mark entry as completed: " + e.getMessage());
        }
    }

    /**
     * Handles the action of the Go Back button.
     * This includes closing the current stage.
     */
    @FXML
    public void goBack() {
        Stage stage = (Stage) entryListView.getScene().getWindow();
        stage.close();
    }

    /**
     * Shows an alert with the specified title and message.
     *
     * @param title The title of the alert.
     * @param message The message of the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}