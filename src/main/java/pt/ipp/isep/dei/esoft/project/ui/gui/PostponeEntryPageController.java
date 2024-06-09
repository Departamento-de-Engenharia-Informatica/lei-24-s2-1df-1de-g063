package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Controller for postponing an entry in the project agenda.
 */
public class PostponeEntryPageController {
    @FXML
    private ListView<Entry> entryListView;
    @FXML
    private ListView<Entry> agendaListView;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Button postponeButton;
    @FXML
    private Label statusLabel;

    private AgendaController controller;

    /**
     * Initializes the controller.
     */
    public void initialize() {
        controller = new AgendaController();
        loadScheduledEntries();
        updateAgendaListView();
    }

    /**
     * Loads scheduled entries into the entry list view.
     */
    private void loadScheduledEntries() {
        List<Entry> scheduledEntries = controller.getAgendaRepository().getEntriesWithStatus(Status.scheduled);
        entryListView.getItems().setAll(scheduledEntries);
    }

    /**
     * Updates the agenda list view with all entries.
     */
    private void updateAgendaListView() {
        List<Entry> allEntries = controller.getAgendaRepository().getEntries();
        agendaListView.getItems().setAll(allEntries);
    }

    /**
     * Handles the action when the postpone button is clicked.
     */
    @FXML
    private void handlePostponeButtonAction() {
        Entry selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null && startDatePicker.getValue() != null) {
            LocalDate newStartDate = startDatePicker.getValue();
            selectedEntry.setStartDate(newStartDate);
            selectedEntry.setEndDate(calculateEndDate(selectedEntry.getDuration(), newStartDate));
            selectedEntry.setStatus(Status.postponed);
            controller.getAgendaRepository().updateEntry(selectedEntry);
            statusLabel.setText("Entry postponed successfully.");
            loadScheduledEntries();
            updateAgendaListView();
        } else {
            statusLabel.setText("Please select an entry and a new start date.");
        }
    }

    /**
     * Handles the action when the go back button is clicked.
     *
     * @param event The action event.
     */
    @FXML
    protected void handleGoBack(ActionEvent event) {
        try {
            Parent assignTeamPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GSMUI.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(assignTeamPage);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the end date based on the duration and start date.
     *
     * @param duration   The duration of the entry in hours.
     * @param startDate  The start date of the entry.
     * @return The calculated end date.
     */
    private LocalDate calculateEndDate(int duration, LocalDate startDate) {
        int fullDays = duration / 8;
        int remainingHours = duration % 8;

        LocalDate endDate = startDate.plusDays(fullDays);

        if (remainingHours > 0) {
            endDate = endDate.plusDays(1);
        }
        return endDate;
    }
}
