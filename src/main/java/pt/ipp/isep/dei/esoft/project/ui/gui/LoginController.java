package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SerializationUtil;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the login user interface.
 * Handles user authentication and navigation between screens.
 */
public class LoginController implements Initializable {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private final AuthenticationController ctrl;

    /**
     * Constructs a new LoginController object.
     */
    public LoginController() {
        this.ctrl = new AuthenticationController();
    }

    /**
     * Handles the login action when the login button is clicked.
     * Authenticates the user and navigates to the appropriate user interface.
     *
     * @param event The action event triggered by the login button click.
     * @throws Exception If an error occurs during login processing.
     */
    @FXML
    protected void handleLogin(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean success = ctrl.doLogin(username, password);
        if (success) {
            String userType = ctrl.getUsernameFromEmail(username); // Get the user type
            String uiPath = ctrl.getUIPath(userType); // Get the path to the FXML file

            Stage stage = (Stage) usernameField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(uiPath));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(userType+" UI");
            stage.show();
            System.out.println(userType+"UI");
        } else {
            Alert alert  = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }

    String filename = "MYINFO.BIN";

    /**
     * Initializes the controller.
     * Deserializes repository information from file on startup.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //----------------<Deserialize info>
        File file = new File(filename);
        if (file.exists() && !file.isDirectory()) {
            Repositories rin = SerializationUtil.deserializeInfo(filename);
            Repositories.setInstance(rin);
        }
        //----------------</Deserialize info>
    }

    /**
     * Handles the action when the exit button is clicked.
     * Serializes repository information to file and exits the application.
     *
     * @param event The action event triggered by the exit button click.
     */
    @FXML
    protected void onExitButtonClick(ActionEvent event) {
        //------------------<Serialize info>
        SerializationUtil.serializeInfo(filename);
        //------------------</Serialize info>

        Platform.exit();
    }
}
