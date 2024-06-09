package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

/**
 * Controller for creating tasks.
 */
public class CreateTaskController {

    private OrganizationRepository organizationRepository;
    private TaskCategoryRepository taskCategoryRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Default constructor. Initializes the repositories.
     */
    public CreateTaskController() {
        getOrganizationRepository();
        getTaskCategoryRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructor that allows receiving the repositories as parameters for testing purposes.
     *
     * @param organizationRepository   the organization repository
     * @param taskCategoryRepository   the task category repository
     * @param authenticationRepository the authentication repository
     */
    public CreateTaskController(OrganizationRepository organizationRepository,
                                TaskCategoryRepository taskCategoryRepository,
                                AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
        this.taskCategoryRepository = taskCategoryRepository;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the task category repository.
     *
     * @return the task category repository
     */
    private TaskCategoryRepository getTaskCategoryRepository() {
        if (taskCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();
            taskCategoryRepository = repositories.getTaskCategoryRepository();
        }
        return taskCategoryRepository;
    }

    /**
     * Retrieves the organization repository.
     *
     * @return the organization repository
     */
    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }

    /**
     * Retrieves the authentication repository.
     *
     * @return the authentication repository
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Creates a new task.
     *
     * @param reference            the task reference
     * @param description          the task description
     * @param informalDescription  the informal description of the task
     * @param technicalDescription the technical description of the task
     * @param duration             the duration of the task
     * @param cost                 the cost of the task
     * @param taskCategoryDescription the description of the task category
     * @return an optional containing the new task if creation was successful, otherwise an empty optional
     */
    public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, int duration, double cost,
                                     String taskCategoryDescription) {

        TaskCategory taskCategory = getTaskCategoryByDescription(taskCategoryDescription);

        Employee employee = getEmployeeFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(employee);

        Optional<Task> newTask = Optional.empty();

        if (organization.isPresent()) {
            newTask = organization.get()
                    .createTask(reference, description, informalDescription, technicalDescription, duration, cost,
                            taskCategory, employee);
        }
        return newTask;
    }

    /**
     * Retrieves the employee from the current session.
     *
     * @return the employee from the current session
     */
    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    /**
     * Retrieves the task category by its description.
     *
     * @param taskCategoryDescription the description of the task category
     * @return the task category
     */
    private TaskCategory getTaskCategoryByDescription(String taskCategoryDescription) {
        TaskCategoryRepository taskCategoryRepository = getTaskCategoryRepository();
        return taskCategoryRepository.getTaskCategoryByDescription(taskCategoryDescription);
    }

    /**
     * Retrieves the list of task categories.
     *
     * @return the list of task categories
     */
    public List<TaskCategory> getTaskCategories() {
        TaskCategoryRepository taskCategoryRepository = getTaskCategoryRepository();
        return taskCategoryRepository.getTaskCategories();
    }
}
