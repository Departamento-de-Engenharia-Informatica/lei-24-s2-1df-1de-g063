package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * This class provides a graphical user interface for canceling an entry.
 * It allows the user to view the list of entries, select an entry, and cancel the selected entry.
 * The class uses an AgendaController to handle the business logic of managing the agenda.
 * It also uses a ToDoList and an AgendaRepository to manage the entries in the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the list of entries.
 * It also includes several FXML-annotated instance variables for interacting with the user interface, including a ListView for displaying the entries, a Button for canceling an entry, a Label for displaying the status, and an AgendaRepository for managing the entries.
 * The class includes a main method, initialize(), which is called when the class is instantiated.
 * This method loads the entries into the ListView and updates the agenda ListView.
 * The class includes several private methods for handling user actions, including canceling an entry, refreshing the entries, updating the agenda ListView, and navigating back to the main page.
 */
public class CancelEntryPageController {
    @FXML
    private ListView<String> entryListView;
    @FXML
    private Label statusLabel;
    @FXML
    private Button cancelButton;
    @FXML
    private ListView<Entry> agendaListView;

    private final AgendaController controller;
    private final ToDoList toDoList;
    private final AgendaRepository agenda;
    private List<Entry> entries;

    /**
     * Constructs a new CancelEntryPageController.
     */
    public CancelEntryPageController() {
        this.controller = new AgendaController();
        this.toDoList = controller.getToDoList();
        this.agenda = controller.getAgendaRepository();
    }

    /**
     * Initializes the controller, loads the entries into the ListView, and updates the agenda ListView.
     */
    @FXML
    public void initialize() {
        loadEntries();
        updateAgendaListView();
    }

    /**
     * Loads the entries into the ListView.
     */
    private void loadEntries() {
        entries = agenda.getAgenda();
        if (entries.isEmpty()) {
            statusLabel.setText("No entries registered yet.");
            cancelButton.setDisable(true);
        } else {
            for (Entry entry : entries) {
                entryListView.getItems().add(entry.toString());
            }
            cancelButton.setDisable(false);
        }
    }

    /**
     * Handles the action of the cancel button.
     * This includes getting the selected entry, canceling the entry, and updating the ListView.
     * If no entry is selected, an error message is displayed.
     */
    @FXML
    public void handleCancelEntry() {
        int selectedIndex = entryListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < entries.size()) {
            Entry selectedEntry = entries.get(selectedIndex);
            selectedEntry.setStatus(Status.canceled);
            statusLabel.setText("Entry has been canceled.");
            refreshEntries();
            updateAgendaListView(); // Update the right side ListView to reflect the changes
        } else {
            statusLabel.setText("No entry selected.");
        }
    }

    /**
     * Refreshes the entries in the ListView.
     */
    private void refreshEntries() {
        entryListView.getItems().clear();
        loadEntries();
    }

    /**
     * Updates the agenda ListView with the entries in the agenda.
     */
    private void updateAgendaListView() {
        List<Entry> allEntries = controller.getAgendaRepository().getEntries();
        agendaListView.getItems().setAll(allEntries);
    }

    /**
     * Handles the action of the Go Back button.
     * This includes loading the main page and setting the scene of the current stage to the main page.
     */
    @FXML
    protected void goBack(ActionEvent event) {
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