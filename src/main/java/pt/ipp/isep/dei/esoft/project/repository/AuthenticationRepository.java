package pt.ipp.isep.dei.esoft.project.repository;

import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

/**
 * The AuthenticationRepository class provides methods to interact with user authentication and session management.
 * It communicates with the authentication facade to perform login, logout, and user management operations.
 * <p>
 * Example usage:
 * <pre>{@code
 * AuthenticationRepository authRepo = new AuthenticationRepository();
 * boolean isLoggedIn = authRepo.doLogin("example@email.com", "password");
 * }</pre>
 */
public class AuthenticationRepository {
    private final AuthFacade authenticationFacade;

    /**
     * Constructs an AuthenticationRepository object.
     */
    public AuthenticationRepository() {
        authenticationFacade = new AuthFacade();
    }

    /**
     * Attempts to log in a user with the provided email and password.
     *
     * @param email the email of the user
     * @param pwd   the password of the user
     * @return true if the login attempt was successful, false otherwise
     */
    public boolean doLogin(String email, String pwd) {
        return authenticationFacade.doLogin(email, pwd).isLoggedIn();
    }

    /**
     * Logs out the currently logged-in user.
     */
    public void doLogout() {
        authenticationFacade.doLogout();
    }

    /**
     * Retrieves the current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentUserSession() {
        return authenticationFacade.getCurrentUserSession();
    }

    /**
     * Adds a user role with the specified ID and description.
     *
     * @param id          the ID of the user role
     * @param description the description of the user role
     * @return true if the user role was successfully added, false otherwise
     */
    public boolean addUserRole(String id, String description) {
        return authenticationFacade.addUserRole(id, description);
    }

    /**
     * Adds a new user with the specified name, email, password, and role ID.
     *
     * @param name   the name of the user
     * @param email  the email of the user
     * @param pwd    the password of the user
     * @param roleId the ID of the user's role
     * @return true if the user was successfully added, false otherwise
     */
    public boolean addUserWithRole(String name, String email, String pwd, String roleId) {
        return authenticationFacade.addUserWithRole(name, email, pwd, roleId);
    }
}
