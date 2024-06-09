package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SerializationUtil;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The ToDoListController class manages the interactions with the to-do list of entries.
 * It allows for the registration of new entries and retrieval of the to-do list.
 * <p>
 * This class provides methods to access the AuthenticationRepository and ToDoList,
 * ensuring that instances of these repositories are properly initialized.
 * It is responsible for handling to-do list entry registration and retrieval.
 */
public class ToDoListController{
    private ToDoList toDoList;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a ToDoListController object.
     * Initializes the AuthenticationRepository and ToDoList attributes.
     */
    public ToDoListController() {
        getToDoList();
        getAuthenticationRepository();
    }

    /**
     * Constructs a ToDoListController object with a specified authentication repository.
     *
     * @param authenticationRepository the authentication repository
     */
    public ToDoListController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the authentication repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Retrieves the to-do list.
     * Initializes the list if it is not already initialized.
     *
     * @return the to-do list
     */
    public ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    /**
     * Registers a new entry in the to-do list.
     *
     * @param task      the task description
     * @param urgency   the urgency of the task
     * @param duration  the estimated duration of the task
     * @param greenSpace the green space related to the task
     * @param status    the status of the task
     * @return the registered entry
     */
    public Entry registerEntry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        return new Entry(task, urgency, duration, greenSpace, status);
    }
}
