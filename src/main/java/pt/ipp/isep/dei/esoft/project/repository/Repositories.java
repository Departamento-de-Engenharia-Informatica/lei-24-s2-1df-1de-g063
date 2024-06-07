package pt.ipp.isep.dei.esoft.project.repository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Repositories implements Serializable {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private transient AuthenticationRepository authenticationRepository;
    private final AgendaRepository agendaRepository;
    private final SkillsRepository skillsRepository;
    private final JobRepository jobRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final VehicleRepository vehicleRepository;
    private final GreenSpaceRepository greenSpaceRepository;
    private final ToDoList toDoList;

    private final TeamRepository teamRepository;

    private Repositories(){
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        skillsRepository = new SkillsRepository();
        jobRepository = new JobRepository();
        collaboratorRepository = new CollaboratorRepository();
        agendaRepository = new AgendaRepository();
        vehicleRepository = new VehicleRepository();
        teamRepository = new TeamRepository();
        greenSpaceRepository = new GreenSpaceRepository();
        toDoList = new ToDoList();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.authenticationRepository = new AuthenticationRepository();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

    public static void setInstance(Repositories instance) {
        Repositories.instance = instance;
    }

    public static Repositories getInstance() {
        if (instance == null) {
                instance = new Repositories();
        }
        return instance;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public CollaboratorRepository getCollaboratorRepository(){
        return collaboratorRepository;
    }

    public AgendaRepository getAgendaRepository() {
        return agendaRepository;
    }

    public SkillsRepository getSkillsRepository() {
        return skillsRepository;
    }

    public JobRepository getJobRepository() {
        return jobRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public VehicleRepository getVehicleRepository(){
        return vehicleRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public GreenSpaceRepository getGreenSpaceRepository() {
        return greenSpaceRepository;
    }

    public ToDoList getToDoList(){
        return toDoList;
    }

    public AgendaRepository getAgenda(){
        return agendaRepository;
    }

}