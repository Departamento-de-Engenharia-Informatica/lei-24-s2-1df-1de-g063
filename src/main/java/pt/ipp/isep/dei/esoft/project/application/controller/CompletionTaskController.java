package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;

/**
 * Controller class responsible for handling the completion of tasks.
 */
public class CompletionTaskController {
    private final AgendaRepository agenda;

    /**
     * Constructs a CompletionTaskController and initializes the agenda repository instance.
     */
    public CompletionTaskController() {
        this.agenda = AgendaRepository.getInstance();
    }

    /**
     * Marks the specified entry as completed and updates it in the agenda repository.
     *
     * @param entry The entry to be marked as completed.
     */
    public void markAsCompleted(Entry entry) {
        entry.setStatus(Status.completed);
        agenda.updateEntry(entry);
    }
}
