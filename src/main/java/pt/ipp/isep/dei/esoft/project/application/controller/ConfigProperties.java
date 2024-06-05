package pt.ipp.isep.dei.esoft.project.application.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private final Properties configProp = new Properties();

    public ConfigProperties() {
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }
}