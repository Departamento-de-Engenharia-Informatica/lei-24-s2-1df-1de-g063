package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenSpaceTest {

    @Test
    void getName() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        String expectedName = "Park1";
        assertEquals(expectedName, greenSpace.getName());
    }

    @Test
    void getManagerName() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        String expectedManagerName = "Francisco";
        assertEquals(expectedManagerName, greenSpace.getManagerName());
    }

    @Test
    void getArea() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        double expectedArea = 100.0;
        assertEquals(expectedArea, greenSpace.getArea());
    }

    @Test
    void testEquals() {
        GreenSpace greenSpace1 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace greenSpace3 = new GreenSpace("Park2", 200.0, Size.Large_Size, "Francisco");

        assertEquals(greenSpace1, greenSpace2); // Test for two equal GreenSpaces
        assertNotEquals(greenSpace1, greenSpace3); // Test for two different GreenSpaces
        assertNotEquals(greenSpace1, null); // Test for comparison with null
        assertNotEquals(greenSpace1, new Object()); // Test for comparison with different type of object
    }

    @Test
    void testToString() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        String expectedString = "GreenSpace{name='Park1', area=100.0, size=Large_Size, manager name='Francisco'}";
        assertEquals(expectedString, greenSpace.toString());
    }
    
}