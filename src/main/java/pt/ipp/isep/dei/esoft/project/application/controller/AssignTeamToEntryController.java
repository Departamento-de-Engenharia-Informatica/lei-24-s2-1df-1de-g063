package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The AssignTeamToEntryController class handles the assignment of teams to entries.
 * It interacts with the TeamRepository and AgendaRepository to perform these operations.
 */
public class AssignTeamToEntryController {
    private TeamRepository teamRepository;
    private AgendaRepository agendaRepository;

    /**
     * Constructs an AssignTeamToEntryController object.
     * Initializes the TeamRepository and AgendaRepository attributes.
     */
    public AssignTeamToEntryController() {
        this.teamRepository = getTeamRepository();
        this.agendaRepository = Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Retrieves a list of all teams.
     *
     * @return a list of Team objects
     */
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    /**
     * Retrieves a specific team by index.
     *
     * @param index the index of the team to retrieve
     * @return the Team object at the specified index
     */
    public Team getTeams(int index) {
        return teamRepository.getTeams(index);
    }

    /**
     * Retrieves a list of entries with flags indicating whether a team is assigned.
     *
     * @return a list of strings representing the entries, with flags for team assignment
     */
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

    /**
     * Assigns a team to an entry and sends notification emails to the team's collaborators.
     *
     * @param choiceTeam  the index of the chosen team
     * @param choiceEntry the index of the chosen entry
     */
    public void attributeTeamToEntry(int choiceTeam, int choiceEntry) {
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
        for (String emailAddress : emailAddresses) {
            try {
                System.out.println("Sending email to " + emailAddress);
                Repositories.getInstance().getEmailSender().sendEmail(System.getProperty("username"), emailAddress, subject, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieves the TeamRepository instance.
     * If the instance is not initialized, initializes it using Repositories.getInstance().
     *
     * @return the TeamRepository instance
     */
    private TeamRepository getTeamRepository() {
        if (teamRepository == null) {
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }
}
