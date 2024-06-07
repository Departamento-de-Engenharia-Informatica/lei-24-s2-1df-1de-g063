package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Entry> toDoList;
    private static ToDoList instance;

    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public static ToDoList getInstance() {
        if (instance == null) {
            instance = new ToDoList();
        }
        return instance;
    }

    public void addEntry(Entry entry) {
        toDoList.add(entry);
    }

    public List<Entry> getToDoList() {
        return List.copyOf(toDoList);
    }

    public List<Entry> getEntriesWithStatus(Status status) {
        return  getToDoList().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(String.valueOf(status)))
                .sorted(Comparator.comparing(Entry::getStatus))
                .collect(Collectors.toList());
    }
}