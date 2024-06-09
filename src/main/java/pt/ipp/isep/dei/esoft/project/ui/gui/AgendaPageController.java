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

/**
 * This class provides a graphical user interface for managing an agenda.
 * It allows the user to view entries in the agenda, add entries to the agenda, and navigate back to the main page.
 * The class uses an AgendaController to handle the business logic of managing the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the start date of an entry and a reference to the selected entry.
 * It also includes several FXML-annotated instance variables for interacting with the user interface, including a ListView for displaying entries, a DatePicker for selecting the start date of an entry, and a Button for adding an entry to the agenda.
 * The class includes a main method, initialize(), which is called when the class is instantiated.
 * This method initializes the controller and loads the entries into the ListView.
 * The class includes several private methods for handling user actions, including adding an entry to the agenda, navigating back to the main page, and calculating the end date of an entry based on its duration and start date.
 */
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

    /**
     * Initializes the controller and loads the entries into the ListView.
     */
    public void initialize() {
        System.out.println("Initialize method called");
        controller = new AgendaController();
        loadEntries();
        System.out.println("startDatePicker: " + startDatePicker);
    }

    /**
     * Loads the entries into the ListView.
     */
    private void loadEntries() {
        System.out.println("Loading entries");
        if (entryListView == null) {
            System.out.println("entryListView is null");
        } else {
            System.out.println("entryListView is not null");
            entryListView.getItems().setAll(controller.getToDoList().getToDoList());
        }
    }

    /**
     * Updates the ListView with the entries in the agenda.
     */
    private void updateAgendaListView() {
        agendaListView.getItems().setAll(controller.getAgendaRepository().getEntries());
    }

    /**
     * Handles the action of the Add button.
     * This includes getting the selected entry, setting its start date, calculating its end date, setting its status to scheduled, adding it to the agenda, and updating the ListView.
     */
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

    /**
     * Handles the action of the Go Back button.
     * This includes loading the main page and setting the scene of the current stage to the main page.
     */
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

    /**
     * Calculates the end date of an entry based on its duration and start date.
     *
     * @param duration The duration of the entry.
     * @param startDate The start date of the entry.
     * @return The end date of the entry.
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