package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.List;

public class AssignTeamPageController {
    @FXML
    private ListView<Team> teamListView;

    @FXML
    private Button confirmButton;

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
    }

    @FXML
    public void confirmSelection() {
        Team selectedTeam = teamListView.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            int index = teamListView.getItems().indexOf(selectedTeam);
            System.out.println("Selected team index: " + index);
        }
    }
}