package pt.ipp.isep.dei.esoft.project.repository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import pt.ipp.isep.dei.esoft.project.application.controller.ConfigProperties;
import pt.ipp.isep.dei.esoft.project.component.EmailSender;
import pt.ipp.isep.dei.esoft.project.component.EmailSenderFile;

import java.lang.reflect.InvocationTargetException;

/**
 * The Repositories class is a singleton that holds instances of all the repositories in the application.
 * It also includes methods for getting instances of these repositories.
 * The class implements the Serializable interface, which means its instances can be saved to a file and read back.
 */
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
    private transient EmailSender emailSender;

    /**
     * The constructor initializes all the repositories and the email sender.
     * It uses reflection to instantiate the email sender based on a system property.
     * If the system property is not set or the specified class cannot be instantiated, it defaults to EmailSenderFile.
     */
    protected Repositories(){
        ConfigProperties properties = new ConfigProperties();

        try {
            String configEmailSender = System.getProperties().getProperty("emailSender", EmailSenderFile.class.getCanonicalName());
            Class<EmailSender> zClass = (Class<EmailSender>) Class.forName(configEmailSender);
            emailSender = zClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            System.out.println("Could not instantiate class... Using default instead");
            emailSender = new EmailSenderFile();
            e.printStackTrace();
        }

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

    /**
     * This method is called when an instance of this class is deserialized.
     * It initializes the transient fields.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.authenticationRepository = new AuthenticationRepository();
    }

    /**
     * This method is called when an instance of this class is serialized.
     * It writes the non-transient fields to the output stream.
     */
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

    /**
     * This method sets the instance of this singleton class.
     */
    public static void setInstance(Repositories instance) {
        Repositories.instance = instance;
    }

    /**
     * This method returns the instance of this singleton class.
     * If the instance is null, it creates a new instance.
     */
    public static Repositories getInstance() {
        if (instance == null) {
            instance = new Repositories();
        }
        return instance;
    }

    // The following methods return instances of the respective repositories.

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

    /**
     * This method returns the instance of the email sender.
     */
    public EmailSender getEmailSender() {
        return emailSender;
    }
}