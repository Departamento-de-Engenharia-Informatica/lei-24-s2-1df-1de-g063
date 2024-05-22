package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

/**
 * The AuthenticationController class manages authentication operations in the application.
 * It provides methods for user login, logout, and retrieval of user roles.
 * <p>
 * The class defines constants for different user roles such as ROLE_ADMIN, ROLE_EMPLOYEE, ROLE_HRM, and ROLE_VFM.
 * It delegates authentication operations to the AuthenticationRepository.
 * <p>
 * Example usage:
 * <pre>{@code
 * AuthenticationController authController = new AuthenticationController();
 * boolean loggedIn = authController.doLogin("user@example.com", "password123");
 * if (loggedIn) {
 *     List<UserRoleDTO> userRoles = authController.getUserRoles();
 *     // Process user roles
 * } else {
 *     System.out.println("Login failed. Invalid credentials.");
 * }
 * }</pre>
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class AuthenticationController {

    /** The constant representing the Administrator role. */
    public static final String ROLE_ADMIN = "ADMINISTRATOR";

    /** The constant representing the Employee role. */
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    /** The constant representing the HR Manager role. */
    public static final String ROLE_HRM = "HRM";

    /** The constant representing the Vendor Finance Manager role. */
    public static final String ROLE_VFM = "VFM";

    public static final String ROLE_GSM = "GSM";

    //private final ApplicationSession applicationSession;
    private final AuthenticationRepository authenticationRepository;

    /**
     * Constructs an AuthenticationController object.
     * Initializes the authenticationRepository attribute.
     */
    public AuthenticationController() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    /**
     * Attempts to authenticate a user with the provided email and password.
     *
     * @param email the user's email address
     * @param pwd   the user's password
     * @return true if the login is successful, false otherwise
     */
    public boolean doLogin(String email, String pwd) {
        try {
            return authenticationRepository.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Retrieves the roles associated with the currently logged-in user.
     *
     * @return a list of UserRoleDTO objects representing the user roles, or null if no user is logged in
     */
    public List<UserRoleDTO> getUserRoles() {
        if (authenticationRepository.getCurrentUserSession().isLoggedIn()) {
            return authenticationRepository.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    /**
     * Logs out the current user.
     */
    public void doLogout() {
        authenticationRepository.doLogout();
    }
}
