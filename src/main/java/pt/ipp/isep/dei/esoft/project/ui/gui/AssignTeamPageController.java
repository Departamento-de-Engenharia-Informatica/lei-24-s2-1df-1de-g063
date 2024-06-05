package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;

import java.util.List;

public class AssignTeamPageController {
    @FXML
    private ListView<Team> teamListView;

    @FXML
    private ListView<String> entryListView;

    @FXML
    private Button confirmButton;

    private int choiceTeam;

    private int choiceEntry;

    private AssignTeamToEntryController assignTeamToEntryController;

    public AssignTeamPageController() {
        this.assignTeamToEntryController = new AssignTeamToEntryController();
    }

    @FXML
    public void initialize() {
        List<Team> teams = assignTeamToEntryController.getTeams();
        if (teams.isEmpty()) {
            System.out.println("No teams available");
        } else {
            teamListView.getItems().addAll(teams);
        }

        List<String> entries = assignTeamToEntryController.getEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries available");
        } else {
            entryListView.getItems().addAll(entries);
        }
    }


    @FXML
    public void confirmSelection() {
        Team selectedTeam = teamListView.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            choiceTeam = teamListView.getItems().indexOf(selectedTeam);
            System.out.println("Selected team index: " + choiceTeam);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No team selected");
            alert.setContentText("Please select a team to confirm");
            alert.showAndWait();

        }
        String selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            choiceEntry = entryListView.getItems().indexOf(selectedEntry);
            System.out.println("Selected entry index: " + choiceEntry);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No entry selected");
            alert.setContentText("Please select an entry to confirm");
            alert.showAndWait();
        }

        if(selectedTeam != null && selectedEntry != null && !selectedEntry.contains("(Team assigned)")){
            assignTeamToEntryController.attributeTeamToEntry(choiceTeam, choiceEntry);
        }
        if(AgendaRepository.getEntries().get(choiceEntry).getTeam() == selectedTeam){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Team assigned successfully");
            alert.setContentText("The team has been successfully assigned to the entry");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Team not assigned");
            alert.setContentText("The team could not be assigned to the entry");
            alert.showAndWait();
        }
    }

}