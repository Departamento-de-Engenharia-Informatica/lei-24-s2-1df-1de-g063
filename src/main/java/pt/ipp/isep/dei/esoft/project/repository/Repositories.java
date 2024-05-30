package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
//    private final AgendaRepository agendaRepository;
    private final SkillsRepository skillsRepository;
    private final JobRepository jobRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final VehicleRepository vehicleRepository;
    private final GreenSpaceRepository greenSpaceRepository;
    private final ToDoList toDoList;

    private final TeamRepository teamRepository;

    private Repositories() {
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        skillsRepository = new SkillsRepository();
        jobRepository = new JobRepository();
        collaboratorRepository = new CollaboratorRepository();
//        agendaRepository = new AgendaRepository();
        vehicleRepository = new VehicleRepository();
        teamRepository = new TeamRepository();
        greenSpaceRepository = new GreenSpaceRepository();
        toDoList = new ToDoList();
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
        return CollaboratorRepository.getInstance();
    }

//    public AgendaRepository getAgendaRepository() {
//        return AgendaRepository.getInstance();
//    }

    public SkillsRepository getSkillsRepository() {
        return SkillsRepository.getInstance();
    }

    public JobRepository getJobRepository() {
        return JobRepository.getInstance();
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public VehicleRepository getVehicleRepository(){
        return VehicleRepository.getInstance();
    }

    public TeamRepository getTeamRepository() {
        return TeamRepository.getInstance();
    }

    public GreenSpaceRepository getGreenSpaceRepository() {
        return GreenSpaceRepository.getInstance();
    }

    public ToDoList getToDoList(){
        return ToDoList.getInstance();
    }

}