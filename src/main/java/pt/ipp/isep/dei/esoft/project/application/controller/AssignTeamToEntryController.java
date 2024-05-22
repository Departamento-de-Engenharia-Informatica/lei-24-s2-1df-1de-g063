package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import java.util.ArrayList;
import java.util.List;
public class AssignTeamToEntryController {
    private final TeamRepository teamRepository;
    public AssignTeamToEntryController(){
        this.teamRepository = new TeamRepository();

    }

    public List<Team> getTeams(){
        return(teamRepository.getTeams());

    }
}
