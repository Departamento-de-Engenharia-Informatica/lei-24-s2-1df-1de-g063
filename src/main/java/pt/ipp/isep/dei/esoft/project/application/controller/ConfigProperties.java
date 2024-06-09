package pt.ipp.isep.dei.esoft.project.application.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is responsible for loading and providing access to configuration properties.
 */
public class ConfigProperties {
    private final Properties configProp = System.getProperties();

    /**
     * Constructs a ConfigProperties object and loads the properties from the "config.properties" file.
     * If the file is not found or an error occurs during loading, it falls back to the default system properties.
     */
    public ConfigProperties() {
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println("[WARNING] Using default properties!");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the property value associated with the specified key.
     *
     * @param key the property key to look up
     * @return the property value associated with the key, or {@code null} if the key is not found
     */
    public String getProperty(String key) {
        return configProp.getProperty(key);
    }
}
