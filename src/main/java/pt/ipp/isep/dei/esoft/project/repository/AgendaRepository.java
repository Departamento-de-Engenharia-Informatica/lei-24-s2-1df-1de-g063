package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository class for managing entries in an agenda.
 */
public class AgendaRepository implements Serializable {
    private List<Entry> agenda;
    private static AgendaRepository instance;

    /**
     * Constructs a new AgendaRepository.
     */
    public AgendaRepository() {
        agenda = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of AgendaRepository.
     *
     * @return the instance of AgendaRepository
     */
    public static AgendaRepository getInstance() {
        if (instance == null) {
            instance = new AgendaRepository();
        }
        return instance;
    }

    /**
     * Adds an entry to the agenda.
     *
     * @param entry the entry to add
     */
    public void addEntry(Entry entry) {
        agenda.add(entry);
    }

    /**
     * Retrieves a copy of all entries in the agenda.
     *
     * @return a list of all entries in the agenda
     */
    public List<Entry> getEntries() {
        return List.copyOf(agenda);
    }

    /**
     * Retrieves the entry at the specified index in the agenda.
     *
     * @param index the index of the entry to retrieve
     * @return the entry at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Entry getEntries(int index) {
        if (index >= 0 && index < agenda.size()) {
            return agenda.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Retrieves a copy of all entries in the agenda.
     *
     * @return a list of all entries in the agenda
     */
    public List<Entry> getAgenda() {
        return List.copyOf(agenda);
    }

    /**
     * Updates an existing entry in the agenda.
     *
     * @param updatedEntry the updated entry
     */
    public void updateEntry(Entry updatedEntry) {
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).equals(updatedEntry)) {
                agenda.set(i, updatedEntry);
                return;
            }
        }
    }

    /**
     * Retrieves a list of entries with the specified status.
     *
     * @param status the status of the entries to retrieve
     * @return a list of entries with the specified status
     */
    public List<Entry> getEntriesWithStatus(Status status) {
        return getEntries().stream()
                .filter(entry -> entry.getStatus() == status)
                .sorted(Comparator.comparing(Entry::getStatus))
                .collect(Collectors.toList());
    }
}
