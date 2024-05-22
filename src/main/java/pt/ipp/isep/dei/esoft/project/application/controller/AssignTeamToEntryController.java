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

    public List<Team> getTeams(){
        return(teamRepository.getTeams());

    }
    private TeamRepository getTeamRepository(){
        if(teamRepository == null){
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }
}
