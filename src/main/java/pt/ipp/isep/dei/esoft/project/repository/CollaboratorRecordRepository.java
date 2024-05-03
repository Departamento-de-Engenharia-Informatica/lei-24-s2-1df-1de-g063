package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorRecordRepository {

    private final List<Collaborator> collaborators;

    public CollaboratorRecordRepository() {
        this.collaborators = new ArrayList<>();
    }

    public Optional<Collaborator> add(Collaborator collaborator) {
        Optional<Collaborator> newCollaborator = Optional.empty();
        boolean operationSuccess = false;

        if (validateCollaborator(collaborator)) {
            newCollaborator = Optional.of(collaborator);
            operationSuccess = collaborators.add(newCollaborator.get());
        }

        if (!operationSuccess) {
            newCollaborator = Optional.empty();
        }

        return newCollaborator;
    }




    public Optional<Collaborator> remove(Collaborator collaborator) {
        Optional<Collaborator> newCollaborator = Optional.empty();
        boolean operationSuccess = false;

        if (collaborators.contains(collaborator)) {
            newCollaborator = Optional.of(collaborator);
            operationSuccess = collaborators.remove(newCollaborator.get());
        }

        if (!operationSuccess) {
            newCollaborator = Optional.empty();
        }

        return newCollaborator;
    }

    public Collaborator update(Collaborator collaborator, String name, String email, String address, String phone, Job job, List<Skill> skills, String birthDate, String IDtype, int taxpayerNumber, int citizenNumber) {
        boolean operationSuccess = false;

        if (collaborators.contains(collaborator)) {
            this.collaborators.remove(collaborator);
            collaborator.setName(name);
            collaborator.setEmail(email);
            collaborator.setAddress(address);
            collaborator.setCellphone_number(phone);
            collaborator.setJob(job);
            collaborator.setSkills(skills);
            collaborator.setBirthDate(birthDate);
            collaborator.setIDtype(IDtype);
            collaborator.setTaxpayerNumber(taxpayerNumber);
            collaborator.setIDNumber(citizenNumber);
            operationSuccess = true;
            this.collaborators.add(collaborator);
        }

        if (!operationSuccess) {
            throw new IllegalArgumentException("Collaborator not found.");
        }

        return collaborator;
    }


    private boolean validateCollaborator(Collaborator collaborator) {
        // Check if the collaborator is already in the repository
        if (collaborators.contains(collaborator)) {
            return false;
        }

        // Check if any parameter is null or empty
        if (collaborator.getName() == null || collaborator.getName().isEmpty() ||
                collaborator.getEmail() == null || collaborator.getEmail().isEmpty() ||
                collaborator.getAddress() == null || collaborator.getAddress().isEmpty() ||
                collaborator.getCellphone_number() == null || collaborator.getCellphone_number().isEmpty() ||
                collaborator.getJob() == null ||
                collaborator.getBirthDate() == null || collaborator.getBirthDate().isEmpty()) {
            return false;
        }

        // Check if the ID type, taxpayer number and the citizen number are valid
        return collaborator.getIDtype() != null && !collaborator.getIDtype().isEmpty() &&
                collaborator.getTaxpayerNumber() > 0 &&
                collaborator.getIDNumber() > 0;
    }


    public List<Collaborator> getCollaborators() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(collaborators);
    }
}