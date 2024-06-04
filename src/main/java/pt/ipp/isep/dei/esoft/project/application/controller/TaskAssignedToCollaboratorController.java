package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskAssignedToCollaboratorController {
    private ToDoList toDoList;
    private String managerName;

    public TaskAssignedToCollaboratorController(String managerName) {
        this.toDoList = ToDoList.getInstance(); // Assuming ToDoList is a singleton
        this.managerName = managerName;
    }

    public List<Entry> getEntriesBetweenDates(LocalDate startDate, LocalDate endDate, String status, String name) {
        return toDoList.getToDoList().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(status))
                .filter(entry -> managerName.equals(name))
                .filter(entry -> !entry.getStartDate().isBefore(startDate) && !entry.getEndDate().isAfter(endDate))
                .sorted(Comparator.comparing(Entry::getStartDate))
                .collect(Collectors.toList());
    }
}
