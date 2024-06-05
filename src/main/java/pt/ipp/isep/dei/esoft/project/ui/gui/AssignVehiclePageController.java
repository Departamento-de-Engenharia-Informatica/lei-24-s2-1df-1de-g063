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

import java.util.List;

public class AssignVehiclePageController {
    @FXML
    private ListView<Vehicle> vehicleListView;

    @FXML
    private ListView<Entry> entryListView;

    @FXML
    private Button confirmButton;

    private int choiceVehicle;

    private int choiceEntry;

    private AssignVehicleToEntryController assignVehicleToEntryController;

    public AssignVehiclePageController() {
        this.assignVehicleToEntryController = new AssignVehicleToEntryController();
    }

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

   @FXML
public void confirmSelection() {
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
            }
        }
    }

    if (allVehiclesAssigned && AgendaRepository.getEntries().get(choiceEntry).getVehicles().containsAll(selectedVehicles)) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Vehicles assigned successfully");
        alert.setContentText("The vehicles have been successfully assigned to the entry");
        alert.showAndWait();
    } else if (!allVehiclesAssigned) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Vehicles not assigned");
        alert.setContentText("Some vehicles could not be assigned to the entry");
        alert.showAndWait();
    }
}

}