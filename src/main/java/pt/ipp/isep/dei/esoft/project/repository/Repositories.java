package pt.ipp.isep.dei.esoft.project.repository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import pt.ipp.isep.dei.esoft.project.application.controller.ConfigProperties;
import pt.ipp.isep.dei.esoft.project.component.EmailSender;
import pt.ipp.isep.dei.esoft.project.component.EmailSenderFile;

/**
 * The Repositories class provides access to various repositories used in the system.
 * It manages the initialization and retrieval of repository instances.
 * <p>
 * This class implements the Singleton design pattern to ensure that only one instance
 * of the Repositories class is created and used throughout the application.
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
     * Constructs a Repositories object.
     * Initializes repository instances and the email sender.
     */
    private Repositories() {
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
     * Custom deserialization method.
     * Reinitializes the authentication repository after deserialization.
     *
     * @param ois The input stream to read from.
     * @throws IOException            If an I/O error occurs.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.authenticationRepository = new AuthenticationRepository();
    }

    /**
     * Custom serialization method.
     *
     * @param oos The output stream to write to.
     * @throws IOException If an I/O error occurs.
     */
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

    /**
     * Sets the instance of Repositories.
     *
     * @param instance The Repositories instance to set.
     */
    public static void setInstance(Repositories instance) {
        Repositories.instance = instance;
    }

    /**
     * Retrieves the singleton instance of Repositories.
     * If the instance is not yet created, it creates a new one.
     *
     * @return The singleton instance of Repositories.
     */
    public static Repositories getInstance() {
        if (instance == null) {
            instance = new Repositories();
        }
        return instance;
    }

    // Getter methods for repository instances

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public CollaboratorRepository getCollaboratorRepository() {
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

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public GreenSpaceRepository getGreenSpaceRepository() {
        return greenSpaceRepository;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }
}
