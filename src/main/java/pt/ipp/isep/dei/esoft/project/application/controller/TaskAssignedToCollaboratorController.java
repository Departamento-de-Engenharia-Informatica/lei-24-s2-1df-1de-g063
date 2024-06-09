package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class responsible for managing tasks assigned to a collaborator.
 */
public class TaskAssignedToCollaboratorController {
    private AgendaRepository agendaRepository;
    private String managerName;

    /**
     * Constructs a TaskAssignedToCollaboratorController with the specified manager name.
     *
     * @param managerName the name of the manager
     */
    public TaskAssignedToCollaboratorController(String managerName) {
        this.agendaRepository = Repositories.getInstance().getAgendaRepository(); // Assuming AgendaRepository is a singleton
        this.managerName = managerName;
    }

    /**
     * Retrieves a list of entries between the specified start and end dates,
     * filtered by status and assigned team member's name.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @param status    the status of the entries to filter by
     * @param name      the name of the team member
     * @return a list of entries matching the criteria
     */
    public List<Entry> getEntriesBetweenDates(LocalDate startDate, LocalDate endDate, String status, String name) {
        return agendaRepository.getEntries().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(status))
                .filter(entry -> entry.getTeam().getMembers().stream()
                        .anyMatch(member -> member.getName().equals(name)))
                .filter(entry -> !entry.getStartDate().isBefore(startDate) && !entry.getEndDate().isAfter(endDate))
                .sorted(Comparator.comparing(Entry::getStartDate))
                .collect(Collectors.toList());
    }
}
