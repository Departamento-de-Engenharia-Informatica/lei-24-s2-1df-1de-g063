package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class CollaboratorRecordRepository {
    private final List<Collaborator> collaborators;

    public CollaboratorRecordRepository() {
        collaborators = new ArrayList<>();
    }
    public void addCollaborator(Collaborator collaborator) {
        collaborators.add(collaborator);
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public Optional<Collaborator> findCollaboratorByEmail(String email) {
        for (Collaborator collaborator : this.collaborators) {
            if (collaborator.getEmail().equals(email)) {
                return Optional.of(collaborator);
            }
        }
        return Optional.empty();
    }

    public void RegisterCollaborator(String name, String email, String address, int phone, String job, String skills, String birthDate, String iDtype, int taxpayerNumber, int citizenNumber, String admissionDate) {
    }
}