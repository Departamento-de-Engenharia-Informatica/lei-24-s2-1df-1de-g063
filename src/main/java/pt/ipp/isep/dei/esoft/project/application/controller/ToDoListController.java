package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.time.LocalDate;

public class ToDoListController {
    private ToDoList toDoList;
    private AuthenticationRepository authenticationRepository;

    public ToDoListController() {
        getToDoList();
        getAuthenticationRepository();
    }

    public ToDoListController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    public Entry registerEntry (String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        return new Entry(task, urgency, duration,greenSpace,status);
    }

}
