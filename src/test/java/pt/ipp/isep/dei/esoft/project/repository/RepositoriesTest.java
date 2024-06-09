package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoriesTest {

    @Test
    void testGetInstance() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance);
    }

    @Test
    void testGetOrganizationRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getOrganizationRepository());
    }

    @Test
    void testGetTaskCategoryRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getTaskCategoryRepository());
    }

    @Test
    void testSetInstance() {
        Repositories instance = new Repositories();
        Repositories.setInstance(instance);
        assertEquals(instance, Repositories.getInstance());
    }

    @Test
    void testGetCollaboratorRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getCollaboratorRepository());
    }

    @Test
    void testGetAgendaRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getAgendaRepository());
    }

    @Test
    void testGetSkillsRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getSkillsRepository());
    }

    @Test
    void testGetJobRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getJobRepository());
    }

    @Test
    void testGetAuthenticationRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getAuthenticationRepository());
    }

    @Test
    void testGetVehicleRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getVehicleRepository());
    }

    @Test
    void testGetTeamRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getTeamRepository());
    }

    @Test
    void testGetGreenSpaceRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getGreenSpaceRepository());
    }

    @Test
    void testGetToDoList() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getToDoList());
    }

    @Test
    void testGetAgenda() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getAgenda());
    }

    @Test
    void testGetEmailSender() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getEmailSender());
    }
}