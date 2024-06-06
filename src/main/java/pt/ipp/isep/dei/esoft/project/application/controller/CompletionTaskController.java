package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;

public class CompletionTaskController {
    private final AgendaRepository agenda;

    public CompletionTaskController() {
        this.agenda = AgendaRepository.getInstance();
    }

    public void markAsCompleted(Entry entry) {
        entry.setStatus(Status.completed);
        agenda.updateEntry(entry);
    }
}