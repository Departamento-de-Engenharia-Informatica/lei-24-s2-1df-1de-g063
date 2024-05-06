package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;


import java.time.LocalDate;


public class RegisterCollaboratorController {
    private JobRepository jobRepository;
    private CollaboratorRepository collaboratorRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterCollaboratorController() {
        getJobRepository();
        getAuthenticationRepository();
        getCollaboratorRepository();
    }

    public RegisterCollaboratorController(AuthenticationRepository authenticationRepository) {
        this.jobRepository = JobRepository.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }


    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public Collaborator registerCollaborator(String name, String adress, String email, String phoneNumber, String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {

        return new Collaborator(name, adress, email, phoneNumber, idType, idNumber, birthDate, admissionDate, job);
    }

}
