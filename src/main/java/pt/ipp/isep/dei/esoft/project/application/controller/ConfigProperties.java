package pt.ipp.isep.dei.esoft.project.application.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private Properties properties;

    public ConfigProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            // load a properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
