package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Organization {
    private final String vatNumber;
    private final List<Employee> employees;
    private final List<Task> tasks;
    private final List<Job> jobs;
    private String name;
    private String website;
    private String phone;
    private String email;

    /**
     * This method is the constructor of the organization.
     *
     * @param vatNumber The vat number of the organization. This is the identity of the organization, therefore it
     *                  cannot be changed.
     */
    public Organization(String vatNumber) {
        this.vatNumber = vatNumber;
        employees = new ArrayList<>();
        tasks = new ArrayList<>();
        jobs = new ArrayList<>();
    }

    /**
     * This method checks if an employee works for the organization.
     *
     * @param employee The employee to be checked.
     * @return True if the employee works for the organization.
     */
    public boolean employs(Employee employee) {
        return employees.contains(employee);
    }

    /**
     * This method creates a new task.
     *
     * @param name            The reference of the task to be created.
     * @param email          The description of the task to be created.
     * @param address  The informal description of the task to be created.
     * @param phone The technical description of the task to be created.
     * @param job             The duration of the task to be created.
     * @param skills                 The cost of the task to be created.
     * @param taxpayerNumber         The task category of the task to be created.
     * @param citizenNumber             The employee of the task to be created.
     * @param admissionDate
     * @param birthDate
     * @param IDtype
     */
    public Optional<Collaborator> createCollaborator(String email, String name, String address, int phone, String job, String skills, String birthDate, String IDtype, String taxpayerNumber, int citizenNumber, int admissionDate) {

        //TODO: we could also check if the employee works for the organization before proceeding
        //checkIfEmployeeWorksForOrganization(employee);

        // When a Task is added, it should fail if the Task already exists in the list of Tasks.
        // In order to not return null if the operation fails, we use the Optional class.
        Optional<Collaborator> optionalValue = Optional.empty();

        Collaborator collaborator = new Collaborator(email, name, address, phone, job, birthDate, IDtype, taxpayerNumber, citizenNumber, skills, admissionDate);

        if (addCollaborator(collaborator)) {
            optionalValue = Optional.of(collaborator);
        }
        return optionalValue;
    }

    /**
     * This method adds a task to the list of tasks.
     *
     * @param collaborator The task to be added.
     * @return True if the task was added successfully.
     */
    private boolean addCollaborator(Collaborator collaborator) {
        boolean success = false;
        if (validate(collaborator)) {
            // A clone of the task is added to the list of tasks, to avoid side effects and outside manipulation.
            success = collaborators.add(collaborator.clone());
        }
        return success;

    }

    /**
     * This method validates the task, checking for duplicates.
     *
     * @param collaborator The task to be validated.
     * @return True if the task is valid.
     */
    private boolean validate(Collaborator collaborator) {return collaboratorsDoNotContain(collaborator);
    }

    /**
     * This method checks if the task is already in the list of tasks.
     *
     * @param collaborator The task to be checked.
     * @return True if the task is not in the list of tasks.
     */
    private boolean collaboratorsDoNotContain(Collaborator collaborator) {
        return !collaborators.contains(collaborator);
    }

    public Optional<Job> registerJob(String jobName, Employee employee) {
        Optional<Job> optionalValue = Optional.empty();

        Job job = new Job(jobName);

        if (addJob(job)) {
            optionalValue = Optional.of(job);
        }
        return optionalValue;
    }

    private boolean addJob(Job job) {
        boolean success = false;
        if (validate(job)) {
            success = jobs.add(job.clone());
        }
        return success;
    }
    private boolean validate(Job job) {
        return jobsDoNotContain(job);
    }
    private boolean jobsDoNotContain(Job job) {
        return !jobs.contains(job);
    }


    /**
     * This methos checks if the organization has an employee with the given email.
     *
     * @param email The email to be checked.
     * @return True if the organization has an employee with the given email.
     */
    public boolean anyEmployeeHasEmail(String email) {
        boolean result = false;
        for (Employee employee : employees) {
            if (employee.hasEmail(email)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization that = (Organization) o;
        return vatNumber.equals(that.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }

    //add employee to organization
    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);

        for (Employee in : this.employees) {
            clone.employees.add(in.clone());
        }


        for (Task in : this.tasks) {
            clone.tasks.add(in.clone());
        }

        for (Job in : this.jobs) {
            clone.jobs.add(in.clone());
        }

        return clone;
    }

}