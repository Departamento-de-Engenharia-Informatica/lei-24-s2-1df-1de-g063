package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorRepository {
    private final List<Collaborator> collaborators;
    private static CollaboratorRepository instance;

    public CollaboratorRepository(){
        collaborators = new ArrayList<Collaborator>();
    }

    public static CollaboratorRepository getInstance() {
        if (instance == null) {
            instance = new CollaboratorRepository();
        }
        return instance;
    }

    public void addCollaborator(Collaborator collaborator){
        collaborators.add(collaborator);
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

}