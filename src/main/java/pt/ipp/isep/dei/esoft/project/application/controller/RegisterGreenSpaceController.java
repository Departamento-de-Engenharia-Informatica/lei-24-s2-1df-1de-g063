package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * The RegisterGreenSpaceController class manages the registration of green spaces.
 * It interacts with the GreenSpaceRepository and AuthenticationRepository.
 */
public class RegisterGreenSpaceController {
    private GreenSpaceRepository greenSpaceRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a RegisterGreenSpaceController object and initializes the repositories.
     */
    public RegisterGreenSpaceController() {
        getAuthenticationRepository();
        getGreenSpaceRepository();
    }

    /**
     * Constructs a RegisterGreenSpaceController object with a specified AuthenticationRepository.
     *
     * @param authenticationRepository the authentication repository to use
     */
    public RegisterGreenSpaceController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the green space repository instance. If it is not already initialized, initializes it.
     *
     * @return the green space repository instance
     */
    public GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }

    /**
     * Retrieves the authentication repository instance. If it is not already initialized, initializes it.
     *
     * @return the authentication repository instance
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Registers a new green space with the specified details.
     *
     * @param name       the name of the green space
     * @param area       the area of the green space
     * @param size       the size category of the green space
     * @param managerName the name of the manager responsible for the green space
     * @return the newly registered GreenSpace object
     */
    public GreenSpace registerGreenSpace(String name, double area, Size size, String managerName) {
        return new GreenSpace(name, area, size, managerName);
    }
}
