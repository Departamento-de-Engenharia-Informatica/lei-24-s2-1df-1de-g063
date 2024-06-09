package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * Controller class responsible for managing the green space repository.
 */
public class GreenSpaceListController {
    private GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructs a GreenSpaceListController and initializes the green space repository if not already initialized.
     */
    public GreenSpaceListController() {
        getGreenSpaceRepository();
    }

    /**
     * Retrieves the green space repository instance. If it is not already initialized, it initializes it.
     *
     * @return The green space repository instance.
     */
    public GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }
}
