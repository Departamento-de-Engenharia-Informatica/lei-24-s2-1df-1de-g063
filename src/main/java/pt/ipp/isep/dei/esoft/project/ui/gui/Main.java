package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SerializationUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        launch();
    }

}