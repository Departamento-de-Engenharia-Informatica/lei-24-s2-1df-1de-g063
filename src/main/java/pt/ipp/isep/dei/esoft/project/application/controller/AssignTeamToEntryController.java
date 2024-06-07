package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
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

    private AgendaRepository agendaRepository;
    /**
     * Constructor for AssignTeamToEntryController.
     * Initializes the team repository.
     */
    public AssignTeamToEntryController(){
        this.teamRepository =  getTeamRepository();
        this.agendaRepository=Repositories.getInstance().getAgendaRepository();
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

    public List<String> getEntries() {
    List<Entry> entries = agendaRepository.getEntries();
    List<String> entriesWithFlags = new ArrayList<>();
    for (Entry entry : entries) {
        String entryString = entry.toString();
        if (entry.getTeam() != null) {
            entryString += " (Team assigned)";
        }
        entriesWithFlags.add(entryString);
    }
    return entriesWithFlags;
}




    public void attributeTeamToEntry(int choiceTeam, int choiceEntry){
         Team selectedTeam = teamRepository.getTeams(choiceTeam);
         Entry selectedEntry = agendaRepository.getEntries(choiceEntry);
         selectedEntry.setTeam(selectedTeam);
         List<Collaborator> collaborators = selectedTeam.getMembers();
         List<String> emailAddresses = new ArrayList<>();
         for (Collaborator collaborator : collaborators) {
             emailAddresses.add(collaborator.getEmail());
         }
         Mailer mailer = new Mailer();
         String subject = "Team assignment";
        String message = "You have been assigned to a team for the entry with the following details:\n" +
                "Task: " + selectedEntry.getTask() + "\n" +
                "Team Members: " + selectedEntry.getTeam() + "\n" +
                "Urgency: " + selectedEntry.getUrgency() + "\n" +
                "Duration: " + selectedEntry.getDuration() + "\n" +
                "Green Space: " + selectedEntry.getGreenSpace().getName() + "\n" +
                "Status: " + selectedEntry.getStatus() + "\n" +
                "Start Date: " + selectedEntry.getStartDate() + "\n" +
                "End Date: " + selectedEntry.getEndDate();
            mailer.sendEmailToMultipleRecipients(emailAddresses, subject, message);
    }


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