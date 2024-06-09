package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.ConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

class ConfigPropertiesTest {

    @Test
    void testGetProperty() {
        // Setup
        ConfigProperties config = new ConfigProperties();

        // Execute
        String host = config.getProperty("host");

        // Assert
        assertNotNull(host, "Host property should not be null");
    }

    @Test
    void testGetPropertyWithInvalidKey() {
        // Setup
        ConfigProperties config = new ConfigProperties();

        // Execute
        String invalid = config.getProperty("invalid");

        // Assert
        assertNull(invalid, "Invalid property should be null");
    }

}