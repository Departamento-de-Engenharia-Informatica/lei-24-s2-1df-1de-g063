package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorRecordRepository {
    private final List<Collaborator> collaborators;

    public CollaboratorRecordRepository() {collaborators = new ArrayList<Collaborator>();
    }

    public void addCollaborator(Collaborator collaborator) {collaborators.add(collaborator);
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }
}