package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * The Main class serves as the entry point for the GUI application.
 * It initializes the application and displays the login screen.
 */
public class Main extends Application {

    /**
     * Initializes the GUI application and displays the login screen.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Bootstrap the application
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        // Load the login screen from FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));

        // Create a scene and set it on the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Display the stage
        stage.show();
    }

    /**
     * The main method, launches the GUI application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
