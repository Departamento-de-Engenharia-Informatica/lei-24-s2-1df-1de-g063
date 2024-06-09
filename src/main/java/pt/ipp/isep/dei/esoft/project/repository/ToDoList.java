package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a repository for managing a to-do list of project entries.
 */
public class ToDoList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Entry> toDoList;
    private static ToDoList instance;

    /**
     * Constructs a new ToDoList object.
     * Initializes the to-do list as an empty ArrayList.
     */
    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of the ToDoList.
     *
     * @return The singleton instance of the ToDoList.
     */
    public static ToDoList getInstance() {
        if (instance == null) {
            instance = new ToDoList();
        }
        return instance;
    }

    /**
     * Adds an entry to the to-do list.
     *
     * @param entry The entry to add.
     */
    public void addEntry(Entry entry) {
        toDoList.add(entry);
    }

    /**
     * Retrieves a copy of the to-do list.
     *
     * @return A copy of the to-do list.
     */
    public List<Entry> getToDoList() {
        return List.copyOf(toDoList);
    }

    /**
     * Retrieves entries with a specific status from the to-do list.
     *
     * @param status The status of entries to retrieve.
     * @return A list of entries with the specified status.
     */
    public List<Entry> getEntriesWithStatus(Status status) {
        return getToDoList().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(String.valueOf(status)))
                .sorted(Comparator.comparing(Entry::getStatus))
                .collect(Collectors.toList());
    }
}
