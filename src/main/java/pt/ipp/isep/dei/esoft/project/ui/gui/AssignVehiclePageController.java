package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignVehicleToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

/**
 * This class provides a graphical user interface for assigning a vehicle to an entry.
 * It allows the user to view the list of vehicles and entries, select a vehicle and an entry, and assign the selected vehicle to the selected entry.
 * The class uses an AssignVehicleToEntryController to handle the business logic of assigning the vehicle to the entry.
 * It also uses an AgendaRepository to manage the entries in the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the choice of vehicle and entry.
 * It also includes several FXML-annotated instance variables for interacting with the user interface, including two ListViews for displaying the vehicles and entries, a Button for confirming the selection, and an AgendaRepository for managing the entries.
 * The class includes a main method, initialize(), which is called when the class is instantiated.
 * This method initializes the controller, loads the vehicles and entries into the ListViews, and sets up the confirm button.
 * The class includes several private methods for handling user actions, including confirming the selection of a vehicle and an entry, and displaying an error message if no vehicle or entry is selected or if the vehicle could not be assigned to the entry.
 */
public class AssignVehiclePageController {
    private final AgendaRepository agendaRepositories;

    @FXML
    private ListView<Vehicle> vehicleListView;

    @FXML
    private ListView<Entry> entryListView;

    @FXML
    private Button confirmButton;

    private int choiceVehicle;

    private int choiceEntry;

    private boolean error;

    private AssignVehicleToEntryController assignVehicleToEntryController;

    /**
     * Constructs a new AssignVehiclePageController.
     */
    public AssignVehiclePageController() {
        this.assignVehicleToEntryController = new AssignVehicleToEntryController();
        this.agendaRepositories = Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Initializes the controller, loads the vehicles and entries into the ListViews, and sets up the confirm button.
     */
    @FXML
    public void initialize() {
        vehicleListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<Vehicle> vehicles = assignVehicleToEntryController.getVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available");
        } else {
            vehicleListView.getItems().addAll(vehicles);
        }

        List<Entry> entries = assignVehicleToEntryController.getEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries available");
        } else {
            entryListView.getItems().addAll(entries);
        }
    }

    /**
     * Handles the action of the confirm button.
     * This includes getting the selected vehicle and entry, assigning the vehicle to the entry, and updating the ListView.
     * If no vehicle or entry is selected, or if the vehicle could not be assigned to the entry, an error message is displayed.
     */
    @FXML
    public void confirmSelection() {
        error = false;
        ObservableList<Vehicle> selectedVehicles = vehicleListView.getSelectionModel().getSelectedItems();
        Entry selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        boolean allVehiclesAssigned = true;

        if (selectedEntry != null && selectedVehicles != null) {
            for (Vehicle vehicle : selectedVehicles) {
                if (!selectedEntry.isVehicleAssigned(vehicle)) {
                    choiceVehicle = vehicleListView.getItems().indexOf(vehicle);
                    choiceEntry = entryListView.getItems().indexOf(selectedEntry);
                    assignVehicleToEntryController.attributeVehicleToEntry(choiceVehicle, choiceEntry);
                } else {
                    allVehiclesAssigned = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Vehicle not assigned");
                    alert.setContentText("Vehicle already assigned to the entry");
                    alert.showAndWait();
                    error = true;
                }
            }
        }

        if (allVehiclesAssigned && agendaRepositories.getEntries().get(choiceEntry).getVehicles().containsAll(selectedVehicles)) {
            List<Entry> entries = assignVehicleToEntryController.getEntries();
            entryListView.getItems().clear();
            entryListView.getItems().addAll(entries);
        } else if (!allVehiclesAssigned && !error) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Vehicles not assigned");
            alert.setContentText("Some vehicles could not be assigned to the entry");
            alert.showAndWait();
        }
    }
}