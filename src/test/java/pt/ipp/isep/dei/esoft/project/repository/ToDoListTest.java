package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void getInstance() {
        ToDoList instance1 = ToDoList.getInstance();
        ToDoList instance2 = ToDoList.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void addEntry() {
        ToDoList toDoList = new ToDoList();
        Entry entry = new Entry("task", Urgency.Low, 10, new GreenSpace("Cidade",10, Size.Large_Size,"Francisco"), Status.pending);
        toDoList.addEntry(entry);
        assertTrue(toDoList.getToDoList().contains(entry));
    }

    @Test
    void getToDoList() {
        ToDoList toDoList = new ToDoList();
        Entry entry = new Entry("task", Urgency.Low, 10, new GreenSpace("Cidade",10, Size.Large_Size,"Francisco"), Status.pending);
        toDoList.addEntry(entry);
        List<Entry> entries = toDoList.getToDoList();
        assertTrue(entries.contains(entry));
    }

    @Test
    void getEntriesWithStatus() {
        ToDoList toDoList = new ToDoList();
        Entry entry1 = new Entry("task", Urgency.Low, 10, new GreenSpace("Cidade",10, Size.Large_Size,"Francisco"), Status.pending);
        entry1.setStatus(Status.completed);
        Entry entry2 = new Entry("task", Urgency.Low, 10, new GreenSpace("Cidade",10, Size.Large_Size,"Francisco"), Status.pending);
        entry2.setStatus(Status.pending);
        toDoList.addEntry(entry1);
        toDoList.addEntry(entry2);
        List<Entry> completedEntries = toDoList.getEntriesWithStatus(Status.completed);
        assertTrue(completedEntries.contains(entry1));
        assertFalse(completedEntries.contains(entry2));
    }
}