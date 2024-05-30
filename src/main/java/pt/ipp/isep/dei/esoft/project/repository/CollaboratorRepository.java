package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;

/**
 * The CollaboratorRepository class manages the storage and retrieval of collaborator information.
 * It provides methods to add, retrieve, and save collaborator data.
 * <p>
 * Example usage:
 * <pre>{@code
 * CollaboratorRepository collaboratorRepo = CollaboratorRepository.getInstance();
 * collaboratorRepo.addCollaborator(new Collaborator("John Doe", "123 Main St", "john@example.com", "123456789", "ID", "123ABC", LocalDate.of(1990, 5, 15), LocalDate.of(2020, 1, 1), "Developer"));
 * }</pre>
 */
public class CollaboratorRepository {
    private final List<Collaborator> collaborators;
    private static CollaboratorRepository instance;

    /**
     * Constructs a CollaboratorRepository object.
     */
    public CollaboratorRepository() {
        collaborators = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of CollaboratorRepository.
     *
     * @return the singleton instance of CollaboratorRepository
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
     * @param collaborator the collaborator to add
     */
    public void addCollaborator(Collaborator collaborator) {
        collaborators.add(collaborator);
    }

    /**
     * Retrieves all collaborators stored in the repository.
     *
     * @return a list of all collaborators
     */
    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    /**
     * Saves changes to a collaborator's information in the repository.
     *
     * @param collaborator the collaborator to save
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
