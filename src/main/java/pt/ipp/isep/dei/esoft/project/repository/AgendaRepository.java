package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    private final List<Entry> agenda;
    private static AgendaRepository instance;

    AgendaRepository() {
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

    public List<Entry> getAgenda() {
        return List.copyOf(agenda);
    }
}
