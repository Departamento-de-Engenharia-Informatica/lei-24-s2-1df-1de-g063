package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;

/**
 * The CollaboratorRepository class represents a repository for managing collaborators.
 * It provides methods to add, retrieve, and save collaborators.
 */
public class CollaboratorRepository {
    private final List<Collaborator> collaborators; // List to store collaborators.
    private static CollaboratorRepository instance; // Singleton instance of CollaboratorRepository.

    /**
     * Constructs a new CollaboratorRepository with an empty list of collaborators.
     */
    public CollaboratorRepository() {
        collaborators = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of CollaboratorRepository.
     *
     * @return The singleton instance of CollaboratorRepository.
     */
    public static CollaboratorRepository getInstance() {
        if (instance == null) {
            instance = new CollaboratorRepository();
        }
        return instance;
    }

    /**
     * Adds a collaborator to the repository.
     *
     * @param collaborator The collaborator to add.
     */
    public void addCollaborator(Collaborator collaborator) {
        collaborators.add(collaborator);
    }

    /**
     * Retrieves all collaborators from the repository.
     *
     * @return A list of all collaborators.
     */
    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    /**
     * Saves a collaborator in the repository. If a collaborator with the same ID already exists, it updates the existing one.
     *
     * @param collaborator The collaborator to save or update.
     */
    public void saveCollaborator(Collaborator collaborator) {
        boolean updated = false;
        for (int i = 0; i < collaborators.size() && !updated; i++) {
            if (collaborators.get(i).equals(collaborator)) {
                collaborators.set(i, collaborator);
                updated = true;
            }
        }
    }
}
