package pt.ipp.isep.dei.esoft.project.application.session;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The ApplicationSession class represents the current session of the application.
 * It manages user sessions and application configuration.
 * <p>
 * This class provides methods to retrieve the current user session and access application configuration.
 * <p>
 * Example usage:
 * <pre>{@code
 * ApplicationSession session = ApplicationSession.getInstance();
 * UserSession userSession = session.getCurrentSession();
 * }</pre>
 */
public class ApplicationSession {
    private final AuthenticationRepository authenticationRepository;
    private static final String CONFIGURATION_FILENAME = "src/main/resources/config.properties";
    private static final String COMPANY_DESIGNATION = "Company.Designation";

    /**
     * Constructs an ApplicationSession object.
     * Initializes the authentication repository and loads application configuration.
     */
    private ApplicationSession() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        Properties props = getProperties();
    }

    /**
     * Retrieves the current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentSession() {
        pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return new UserSession(userSession);
    }

    /**
     * Retrieves the application configuration properties.
     *
     * @return the application configuration properties
     */
    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(COMPANY_DESIGNATION, "MusgoSublime");

        // Read configured values
        try {
            InputStream in = new FileInputStream(CONFIGURATION_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    private static ApplicationSession singleton = null;

    /**
     * Retrieves the singleton instance of ApplicationSession.
     *
     * @return the singleton instance of ApplicationSession
     */
    public static ApplicationSession getInstance() {
        if (singleton == null) {
            synchronized (ApplicationSession.class) {
                singleton = new ApplicationSession();
            }
        }
        return singleton;
    }
}
