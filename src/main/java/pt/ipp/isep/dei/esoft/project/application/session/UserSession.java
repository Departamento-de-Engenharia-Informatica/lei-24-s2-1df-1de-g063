package pt.ipp.isep.dei.esoft.project.application.session;

import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

/**
 * The UserSession class represents a user session in the application.
 * It provides methods to access user information and manage the session.
 * <p>
 * Example usage:
 * <pre>{@code
 * UserSession session = new UserSession(userSession);
 * String userEmail = session.getUserEmail();
 * }</pre>
 */
public class UserSession {

    private pt.isep.lei.esoft.auth.UserSession userSession;

    /**
     * Constructs a UserSession object with the provided user session.
     *
     * @param userSession the user session
     */
    public UserSession(pt.isep.lei.esoft.auth.UserSession userSession) {
        this.userSession = userSession;
    }


    /**
     * Retrieves the email of the user associated with the session.
     *
     * @return the email of the user
     */
    public String getUserEmail() {
        return userSession.getUserId().getEmail();
    }

    /**
     * Retrieves the name of the user associated with the session.
     *
     * @return the name of the user
     */
    public String getUserName() {
        return this.userSession.getUserName();
    }

    /**
     * Retrieves the roles assigned to the user associated with the session.
     *
     * @return the roles assigned to the user
     */
    public List<UserRoleDTO> getUserRoles() {
        return this.userSession.getUserRoles();
    }

    /**
     * Logs out the user session.
     */
    public void doLogout() {
        this.userSession.doLogout();
    }

    /**
     * Checks if the user is logged in.
     *
     * @return true if the user is logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return this.userSession.isLoggedIn();
    }

    /**
     * Checks if the user is logged in with a specific role.
     *
     * @param roleId the ID of the role to check
     * @return true if the user is logged in with the specified role, false otherwise
     */
    public boolean isLoggedInWithRole(String roleId) {
        return this.userSession.isLoggedInWithRole(roleId);
    }
}
