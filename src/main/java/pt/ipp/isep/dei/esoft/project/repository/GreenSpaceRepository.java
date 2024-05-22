package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
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
public class GreenSpaceRepository {
    private final List<GreenSpace> greenSpaces;
    private static GreenSpaceRepository instance;

    /**
     * Constructs a CollaboratorRepository object.
     */
    public GreenSpaceRepository() {
        greenSpaces = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of CollaboratorRepository.
     *
     * @return the singleton instance of CollaboratorRepository
     */
    public static GreenSpaceRepository getInstance() {
        if (instance == null) {
            instance = new GreenSpaceRepository();
        }
        return instance;
    }

    /**
     * Adds a collaborator to the repository.
     *
     * @param greenSpace the collaborator to add
     */
    public void addGreenSpace(GreenSpace greenSpace) {
        greenSpaces.add(greenSpace);
    }

    /**
     * Retrieves all collaborators stored in the repository.
     *
     * @return a list of all collaborators
     */
    public List<GreenSpace> getGreenSpaces() {
        return greenSpaces;
    }

    /**
     * Saves changes to a collaborator's information in the repository.
     *
     * @param greenSpace the collaborator to save
     */
    public void saveGreenSpace(GreenSpace greenSpace) {
        boolean updated = false;
        for (int i = 0; i < greenSpaces.size() && !updated; i++) {
            if (greenSpaces.get(i).equals(greenSpace)) {
                greenSpaces.set(i, greenSpace);
                updated = true;
            }
        }
    }
}
