package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Agenda {
    private List<ToDoList> entry;

    public Agenda(ToDoList entry) {
        this.entry = (List<ToDoList>) entry;
    }

    public List<ToDoList> getEntry() {
        return entry;
    }

    public void setEntry(List<ToDoList> entrys) {
        this.entrys = entrys;
    }

    public boolean hasEntry(ToDoList entry) {
        return entrys.contains(entry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda that = (Agenda) o;
        return Objects.equals(entry, that.entry);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "entry=" + entry +
                '}';
    }
}
