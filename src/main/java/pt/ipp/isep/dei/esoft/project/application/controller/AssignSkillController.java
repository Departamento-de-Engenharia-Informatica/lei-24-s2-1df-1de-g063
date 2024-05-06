package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

public class AssignSkillController {
    private CollaboratorRepository collaboratorRepository;
    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;

    public AssignSkillController(){
        getCollaboratorRepository();
        getSkillsRepository();
        getAuthenticationRepository();
    }

    public AssignSkillController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
        this.collaboratorRepository = CollaboratorRepository.getInstance();
    }

    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();

            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    public SkillsRepository getSkillsRepository() {
        if(skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

}
