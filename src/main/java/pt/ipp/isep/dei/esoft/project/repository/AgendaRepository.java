package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    private static List<Entry> agenda;
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

    public static void addEntry(Entry entry) {
        agenda.add(entry);
    }

    public static List<Entry> getEntries() {
        return List.copyOf(agenda);
    }

    public static Entry getEntries(int index) {
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
}
