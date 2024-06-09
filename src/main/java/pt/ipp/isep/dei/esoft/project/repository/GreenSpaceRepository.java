package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The GreenSpaceRepository class represents a repository for managing GreenSpace objects.
 * It provides methods for adding, retrieving, and updating green spaces.
 */
public class GreenSpaceRepository implements Serializable {
    private final List<GreenSpace> greenSpaces;
    private static GreenSpaceRepository instance;

    /**
     * Constructs a GreenSpaceRepository object.
     */
    public GreenSpaceRepository() {
        greenSpaces = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of GreenSpaceRepository.
     *
     * @return the singleton instance of GreenSpaceRepository
     */
    public static GreenSpaceRepository getInstance() {
        if (instance == null) {
            instance = new GreenSpaceRepository();
        }
        return instance;
    }

    /**
     * Adds a green space to the repository.
     *
     * @param greenSpace the green space to add
     */
    public void addGreenSpace(GreenSpace greenSpace) {
        greenSpaces.add(greenSpace);
    }

    /**
     * Retrieves all green spaces stored in the repository.
     *
     * @return a list of all green spaces
     */
    public List<GreenSpace> getGreenSpaces() {
        return greenSpaces;
    }

    /**
     * Retrieves green spaces by manager name.
     *
     * @param managerName the manager's name to filter green spaces
     * @return a list of green spaces managed by the specified manager
     */
    public List<GreenSpace> getGreenSpacesByName(String managerName) {
        return greenSpaces.stream()
                .filter(greenSpace -> greenSpace.getManagerName().equalsIgnoreCase(managerName))
                .collect(Collectors.toList());
    }

    /**
     * Saves a green space by updating it in the repository.
     *
     * @param greenSpace the green space to save
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
