package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.Serializable;

/**
 * Controller class for managing the agenda and related tasks.
 * This class provides methods to access the ToDoList, AgendaRepository,
 * and AuthenticationRepository.
 */
public class AgendaController {

    private ToDoList toDoList;
    private AgendaRepository agendaRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Default constructor.
     * Initializes the controller and ensures all repositories are available.
     */
    public AgendaController() {
        getToDoList();
        getAgendaRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructor with an AuthenticationRepository parameter.
     * Initializes the ToDoList and sets the provided AuthenticationRepository.
     *
     * @param authenticationRepository The authentication repository to use.
     */
    public AgendaController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Gets the ToDoList instance.
     * If the ToDoList is not already initialized, it retrieves it from the repositories.
     *
     * @return The ToDoList instance.
     */
    public ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    /**
     * Gets the AgendaRepository instance.
     * If the AgendaRepository is not already initialized, it retrieves it from the repositories.
     *
     * @return The AgendaRepository instance.
     */
    public AgendaRepository getAgendaRepository() {
        if (agendaRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agendaRepository = repositories.getAgendaRepository();
        }
        return agendaRepository;
    }

    /**
     * Gets the AuthenticationRepository instance.
     * If the AuthenticationRepository is not already initialized, it retrieves it from the repositories.
     *
     * @return The AuthenticationRepository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
}
