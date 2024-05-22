package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import java.util.ArrayList;
import java.util.List;
public class AssignTeamToEntryController {
    private TeamRepository teamRepository;
    public AssignTeamToEntryController(){
        this.teamRepository =  getTeamRepository();

    }

    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    // Overloaded method to get a specific team by index
    public Team getTeams(int index) {
        List<Team> teams = teamRepository.getTeams();
        if (index >= 0 && index < teams.size()) {
            return teams.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
//    public List<Entry> getEntries() {
//        return entryRepository.getEntries();
//    }
//
//    // Overloaded method to get a specific team by index
//    public Entry getEntries(int index) {
//        List<Entry> entries = entryRepository.getEntries();
//        if (index >= 0 && index < entries.size()) {
//            return entries.get(index);
//        } else {
//            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
//        }
//    }

//    public attributeTeamToEntry(Team selectedTeam, Entry selectedEntry){
//        //attribution logic
//    }


    private TeamRepository getTeamRepository(){
        if(teamRepository == null){
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }
}
