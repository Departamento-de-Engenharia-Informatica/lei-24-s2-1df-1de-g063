package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.util.ArrayList;
import java.util.List;

public class ToDoList{
    private final List<Entry> toDoList;
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

}