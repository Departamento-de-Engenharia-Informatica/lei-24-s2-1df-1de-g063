package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;


public class AgendaRepository {
    private final List<Agenda> entrys_agenda;
    private static AgendaRepository instance;

    /**
     * Constructs a CollaboratorRepository object.
     */
    public AgendaRepository() {
        entrys_agenda = new ArrayList<>();
    }


    public static AgendaRepository getInstance() {
        if (instance == null) {
            instance = new AgendaRepository();
        }
        return instance;
    }

    public void addEntry_Agenda(Agenda entry_agenda) {
        entrys_agenda.add(entry_agenda);
    }


    public List<Agenda> getEntrys_Agenda() {
        return entrys_agenda;
    }

    public void saveEntry(Agenda entry_agenda) {
        boolean updated = false;
        for (int i = 0; i < entrys_agenda.size() && !updated; i++) {
            if (entrys_agenda.get(i).equals(entry_agenda)) {
                entrys_agenda.set(i, entry_agenda);
                updated = true;
            }
        }
    }
}
