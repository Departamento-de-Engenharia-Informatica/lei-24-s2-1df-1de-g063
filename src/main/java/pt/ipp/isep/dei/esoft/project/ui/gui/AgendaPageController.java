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
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class AgendaPageController {
    @FXML
    private ListView<Entry> entryListView;
    @FXML
    private ListView<Entry> agendaListView;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Button addButton;

    private AgendaController controller;


    public void initialize() {
        System.out.println("Initialize method called");
        controller = new AgendaController();
        loadEntries();
        System.out.println("startDatePicker: " + startDatePicker);
    }

    private void loadEntries() {
        System.out.println("Loading entries");
        if (entryListView == null) {
            System.out.println("entryListView is null");
        } else {
            System.out.println("entryListView is not null");
            entryListView.getItems().setAll(controller.getToDoList().getToDoList());
        }
    }

    private void updateAgendaListView() {
        agendaListView.getItems().setAll(controller.getAgendaRepository().getEntries());
    }

    @FXML
    private void handleAddButtonAction() {
        Entry selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            selectedEntry.setStartDate(startDatePicker.getValue());
            // calculate end date based on duration
            selectedEntry.setEndDate(calculateEndDate(selectedEntry.getDuration(), startDatePicker.getValue()));
            selectedEntry.setStatus(Status.scheduled);
            controller.getAgendaRepository().addEntry(selectedEntry);
            updateAgendaListView();
        }
    }

    @FXML
    protected void handleGOBACK(ActionEvent event) {
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
