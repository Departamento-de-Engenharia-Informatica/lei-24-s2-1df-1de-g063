package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRecordRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Optional;

public class CollaboratorController {
    private OrganizationRepository organizationRepository;
    private CollaboratorRecordRepository collaboratorRecordRepository;
    private JobRepository jobRepository;
    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;

    public CollaboratorController(){
        getCollaboratorRecordRepository();
        getAuthenticationRepository();
        getOrganizationRepository();
        getJobRepository();
        getSkillsRepository();
        getAuthenticationRepository();
        getOrganizationRepository();
    }

    public CollaboratorController(OrganizationRepository organizationRepository,JobRepository jobRepository,SkillsRepository skillsRepository, CollaboratorRecordRepository collaboratorRecordRepository ,AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
        this.jobRepository = jobRepository;
        this.skillsRepository = skillsRepository;
        this.collaboratorRecordRepository = collaboratorRecordRepository;
        this.authenticationRepository = authenticationRepository;
    }

    public CollaboratorRecordRepository getCollaboratorRecordRepository() {
        if (collaboratorRecordRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            collaboratorRecordRepository = repositories.getCollaboratorRecordRepository();
        }
        return collaboratorRecordRepository;
    }

    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;

    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
     public Optional<Collaborator> RegisterCollaborator(String name, String email, String address, int phone,
                                                        String job, String skills, String birthDate, String IDtype,
                                                        int taxpayerNumber, int citizenNumber, String admissionDate) {
         // Create a Collaborator object with the given details
        collaboratorRecordRepository.RegisterCollaborator(name, email, address, phone, job, skills, birthDate, IDtype, taxpayerNumber, citizenNumber, admissionDate);
         return null;
     }


//    public void RegisterCollaborator(String name, String email, String address, int phone,
//                                         String job, String skills, String birthDate, String IDtype,
//                                         int taxpayerNumber, int citizenNumber, int admissionDate) {
//            // Create a Collaborator object with the given details
//        Collaborator collaborator = new Collaborator(name, email, address, phone,job, skills, birthDate, IDtype, taxpayerNumber, citizenNumber, admissionDate);
//        collaboratorRecordRepository.addCollaborator(collaborator);
//            // Call any necessary methods to add the collaborator to your system (e.g., save to a database)
//            // For example:
//            // collaboratorRepository.save(collaborator);
//        }
//    }
//
//
//    public Optional<Collaborator> RegisterCollaborator(String email, String name, String address, int phone, String job,String skills, String birthDate, String IDtype, String taxpayerNumber, int citizenNumber, int admissionDate) {
//        Employee employee = getEmployeeFromSession();
//        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(employee);
//
//        Optional<Collaborator> newCollaborator = Optional.empty();
//
//        if (organization.isPresent()) {
//            newCollaborator = organization.get().createCollaborator(email, name, address, phone, job, skills, birthDate, IDtype, taxpayerNumber, citizenNumber, admissionDate);
//        }
//        return newCollaborator;
//    }
//    public void registerSkill(Skill skill) {
//
//        if (!validateSkill(skill)) {
//            System.out.println("Skill has not been registered");
//        } else{
//            System.out.println("Skill registered successfully");
//            skillsRepository.addSkill(skill);
//        }
//
//    }
//private boolean validateSkill(Skill skill) {
//    List<Skill> skills = skillsRepository.getSkills();
//    boolean valid = true;
//    for (Skill s : skills) {
//        if (s.toString().equalsIgnoreCase(skill.toString())) {
//            System.out.println("Skill already exists");
//            valid = false;
//        }else if (!skill.toString().matches("abcdefghijklmnopqrstuvwxyz")) {
//            System.out.println("Insert a skill");
//            valid=false;
//        }else if (skill.toString().matches("%€£ºª§&+-<>/|#*$")){
//            System.out.println("Skill has invalid characters");
//            valid=false;
//        }
//    }
//    return valid;
//}

    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    public Object getSkillsRepository() {
        return skillsRepository;
    }

    public void setSkillsRepository(Object skillsRepository) {
        this.skillsRepository = (SkillsRepository) skillsRepository;
    }

    public Object getJobRepository() {
        return jobRepository;
    }

    public void setJobRepository(Object jobRepository) {
        this.jobRepository = (JobRepository) jobRepository;
    }

    public Object getColllaboratorRecordRepository() {
        return collaboratorRecordRepository;
    }

    public void setColllaboratorRecordRepository(Object colllaboratorRecordRepository) {
        this.collaboratorRecordRepository = (CollaboratorRecordRepository) colllaboratorRecordRepository;
    }

}