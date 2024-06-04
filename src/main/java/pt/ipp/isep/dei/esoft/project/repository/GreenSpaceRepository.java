package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<GreenSpace> getGreenSpacesByName(String managerName) {
        return greenSpaces.stream()
                .filter(greenSpace -> greenSpace.getManagerName().equalsIgnoreCase(managerName))
                .collect(Collectors.toList());
    }

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
