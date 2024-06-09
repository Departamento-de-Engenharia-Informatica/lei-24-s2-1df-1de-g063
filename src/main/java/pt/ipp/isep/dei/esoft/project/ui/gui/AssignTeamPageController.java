package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

/**
 * This class provides a graphical user interface for assigning a team to an entry.
 * It allows the user to view the list of teams and entries, select a team and an entry, and assign the selected team to the selected entry.
 * The class uses an AssignTeamToEntryController to handle the business logic of assigning the team to the entry.
 * It also uses an AgendaRepository to manage the entries in the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the choice of team and entry.
 * It also includes several FXML-annotated instance variables for interacting with the user interface, including two ListViews for displaying the teams and entries, a Button for confirming the selection, and an AgendaRepository for managing the entries.
 * The class includes a main method, initialize(), which is called when the class is instantiated.
 * This method initializes the controller, loads the teams and entries into the ListViews, and sets up the confirm button.
 * The class includes several private methods for handling user actions, including confirming the selection of a team and an entry, and displaying an error message if no team or entry is selected or if the team could not be assigned to the entry.
 */
public class AssignTeamPageController {
    private final AgendaRepository agendaRepository;
    @FXML
    private ListView<Team> teamListView;

    @FXML
    private ListView<String> entryListView;

    @FXML
    private Button confirmButton;

    private int choiceTeam;

    private int choiceEntry;

    private List<String> entries;

    private List <Team> teams;

    private AssignTeamToEntryController assignTeamToEntryController;

    /**
     * Constructs a new AssignTeamPageController.
     */
    public AssignTeamPageController() {
        this.assignTeamToEntryController = new AssignTeamToEntryController();
        this.agendaRepository= Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Initializes the controller, loads the teams and entries into the ListViews, and sets up the confirm button.
     */
    @FXML
    public void initialize() {
        teams = assignTeamToEntryController.getTeams();
        if (teams.isEmpty()) {
            System.out.println("No teams available");
        } else {
            teamListView.getItems().addAll(teams);
        }

        entries = assignTeamToEntryController.getEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries available");
        } else {
            entryListView.getItems().addAll(entries);
        }
    }

    /**
     * Handles the action of the confirm button.
     * This includes getting the selected team and entry, assigning the team to the entry, and updating the ListView.
     * If no team or entry is selected, or if the team could not be assigned to the entry, an error message is displayed.
     */
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
        if(agendaRepository.getEntries().get(choiceEntry).getTeam() == selectedTeam){
            entries = assignTeamToEntryController.getEntries();
            entryListView.getItems().clear();
            entryListView.getItems().addAll(entries);
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