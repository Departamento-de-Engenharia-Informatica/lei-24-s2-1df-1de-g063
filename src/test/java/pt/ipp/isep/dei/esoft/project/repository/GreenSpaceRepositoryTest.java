package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreenSpaceRepositoryTest {

    private GreenSpaceRepository repository;

    @BeforeEach
    void setUp() {
        // Reset the singleton instance before each test
        repository = GreenSpaceRepository.getInstance();
        repository.getGreenSpaces().clear();
    }

    @Test
    void testGetInstance() {
        GreenSpaceRepository firstInstance = GreenSpaceRepository.getInstance();
        GreenSpaceRepository secondInstance = GreenSpaceRepository.getInstance();
        assertSame(firstInstance, secondInstance, "getInstance should return the same instance");
    }

    @Test
    void testAddGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        repository.addGreenSpace(greenSpace);
        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(1, greenSpaces.size(), "Should be one green space in the repository");
        assertTrue(greenSpaces.contains(greenSpace), "Repository should contain the added green space");
    }

    @Test
    void testGetGreenSpaces() {
        GreenSpace greenSpace1 = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Riverside Park", 100, Size.Garden,"Francisco");
        repository.addGreenSpace(greenSpace1);
        repository.addGreenSpace(greenSpace2);
        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(2, greenSpaces.size(), "Should be two green spaces in the repository");
        assertTrue(greenSpaces.contains(greenSpace1), "Repository should contain the first added green space");
        assertTrue(greenSpaces.contains(greenSpace2), "Repository should contain the second added green space");
    }

    @Test
    void testGetGreenSpacesByName() {
        GreenSpace greenSpace1 = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Riverside Park", 100, Size.Garden,"Tiago");
        repository.addGreenSpace(greenSpace1);
        repository.addGreenSpace(greenSpace2);
        List<GreenSpace> franciscoGreenSpaces = repository.getGreenSpacesByName("Francisco");
        assertEquals(1, franciscoGreenSpaces.size(), "Should be one green space managed by Francisco");
        assertTrue(franciscoGreenSpaces.contains(greenSpace1), "Repository should contain Francisco's green space");

        List<GreenSpace> tiagoGreenSpaces = repository.getGreenSpacesByName("Tiago");
        assertEquals(1, tiagoGreenSpaces.size(), "Should be one green space managed by Tiago");
        assertTrue(tiagoGreenSpaces.contains(greenSpace2), "Repository should contain Tiago's green space");
    }

    @Test
    void testSaveGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        repository.addGreenSpace(greenSpace);

        GreenSpace updatedGreenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Tiago");
        repository.saveGreenSpace(updatedGreenSpace);

        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(1, greenSpaces.size(), "Should be one green space in the repository after update");
        assertEquals("Tiago", greenSpaces.get(0).getManagerName(), "The manager name should be updated to Tiago");
    }
}
