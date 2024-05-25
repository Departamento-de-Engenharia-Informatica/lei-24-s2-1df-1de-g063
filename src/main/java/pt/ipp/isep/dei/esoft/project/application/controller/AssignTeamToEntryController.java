package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for assigning teams to entries.
 */
public class AssignTeamToEntryController {
    private TeamRepository teamRepository;

    /**
     * Constructor for AssignTeamToEntryController.
     * Initializes the team repository.
     */
    public AssignTeamToEntryController(){
        this.teamRepository =  getTeamRepository();
    }

    /**
     * Retrieves all teams from the team repository.
     * @return a list of all teams.
     */
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    /**
     * Retrieves a specific team from the team repository by index.
     * @param index the index of the team in the list.
     * @return the team at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Team getTeams(int index) {
        return teamRepository.getTeams(index);
    }

    // The following methods are commented out but may be used in the future.
    /*
    public List<Entry> getEntries() {
        return entryRepository.getEntries();
    }

    public Entry getEntries(int index) {
        List<Entry> entries = entryRepository.getEntries();
        if (index >= 0 && index < entries.size()) {
            return entries.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public attributeTeamToEntry(choiceTeam, choiceEntry){
         Team selectedTeam = teamRepository.getTeams(choiceTeam);
         Entry selectedEntry = entryRepository.getEntries(choiceEntry);
    }
    */

    /**
     * Retrieves the team repository.
     * If the team repository is null, it initializes it.
     * @return the team repository.
     */
    private TeamRepository getTeamRepository(){
        if(teamRepository == null){
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }
}