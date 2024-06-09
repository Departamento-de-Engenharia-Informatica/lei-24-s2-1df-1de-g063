package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.ConfigProperties;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;
import java.util.Scanner;

/**
 * The Main class is the entry point for the application.
 */
public class Main {
    /**
     * The main method is the entry point for the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Load configuration properties
        new ConfigProperties();

        // Run bootstrap initialization
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            // Display main menu UI
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
