package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.UserSession;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRepositoryTest {

    private AuthenticationRepository authenticationRepository;

    @BeforeEach
    void setUp() {
        authenticationRepository = new AuthenticationRepository();
    }

    @Test
    void getCurrentUserSession() {
        authenticationRepository.doLogin("test@example.com", "password");
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        assertNotNull(userSession, "User session should not be null after login");
    }

    @Test
    void addUserRole() {
        boolean result = authenticationRepository.addUserRole("testRole", "Test Role");
        assertTrue(result, "Adding user role should be successful");
    }

    @Test
    void addUserWithRole() {
        authenticationRepository.addUserRole("testRole", "Test Role");
        boolean result = authenticationRepository.addUserWithRole("Test User", "test@example.com", "password", "testRole");
        assertTrue(result, "Adding user with role should be successful");
    }
}