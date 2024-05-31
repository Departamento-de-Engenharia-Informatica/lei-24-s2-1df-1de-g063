package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Entry> agenda;
    private static Agenda instance;

    Agenda() {
        agenda = new ArrayList<>();
    }

    public static Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }

    public void addEntry(Entry entry) {
        agenda.add(entry);
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
