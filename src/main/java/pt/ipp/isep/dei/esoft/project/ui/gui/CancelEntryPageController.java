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

    public CancelEntryPageController() {
        this.controller = new AgendaController();
        this.toDoList = controller.getToDoList();
        this.agenda = controller.getAgendaRepository();
    }

    @FXML
    public void initialize() {
        loadEntries();
        updateAgendaListView();
    }

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

    private void refreshEntries() {
        entryListView.getItems().clear();
        loadEntries();
    }

    private void updateAgendaListView() {
        List<Entry> allEntries = controller.getAgendaRepository().getEntries();
        agendaListView.getItems().setAll(allEntries);
    }

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
