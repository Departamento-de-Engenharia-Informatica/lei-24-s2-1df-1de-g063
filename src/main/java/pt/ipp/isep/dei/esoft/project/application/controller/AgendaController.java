package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agenda;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.*;


import java.time.LocalDate;

public class AgendaController {
    private ToDoList toDoList;
    private AgendaRepository agendaRepository;
    private AuthenticationRepository authenticationRepository;

    public AgendaController() {
        getToDoList();
        getAgendaRepository();
        getAuthenticationRepository();

    }

    public AgendaController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    private ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    public AgendaRepository getAgendaRepository() {
        if (agendaRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agendaRepository = repositories.getAgendaRepository();
        }
        return agendaRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
    public Agenda registerEntry(ToDoList entry) {
        return new Entry(entry);
    }
}

