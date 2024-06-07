package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaRepository implements Serializable {
    private List<Entry> agenda;
    private static AgendaRepository instance;

    public AgendaRepository() {
        agenda = new ArrayList<>();
    }

    public static AgendaRepository getInstance() {
        if (instance == null) {
            instance = new AgendaRepository();
        }
        return instance;
    }

    public void addEntry(Entry entry) {
        agenda.add(entry);
    }

    public List<Entry> getEntries() {
        return List.copyOf(agenda);
    }

    public Entry getEntries(int index) {
        if (index >= 0 && index < agenda.size()) {
            return agenda.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public List<Entry> getAgenda() {
        return List.copyOf(agenda);
    }

    public void updateEntry(Entry updatedEntry) {
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).equals(updatedEntry)) {
                agenda.set(i, updatedEntry);
                return;
            }
        }
    }

    public List<Entry> getEntriesWithStatus(Status status) {
        return  getEntries().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(String.valueOf(status)))
                .sorted(Comparator.comparing(Entry::getStatus))
                .collect(Collectors.toList());
    }

}
