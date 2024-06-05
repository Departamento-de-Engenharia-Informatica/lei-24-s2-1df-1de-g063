package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.io.IOException;
import java.util.Objects;

public class RegisterGreenSpacePageController {
    @FXML
    private ListView<GreenSpace> greenSpaceListView;
    private final RegisterGreenSpaceController controller;

    @FXML
    private TextField nameField;
    @FXML
    private TextField managerField;
    @FXML
    private TextField areaField;
    private GreenSpaceRepository greenSpaceRepository;

    public RegisterGreenSpacePageController() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    @FXML
    protected void registerGreenSpace() {
        try {
            double area = Double.parseDouble(areaField.getText());
            String name = nameField.getText();
            String managerName = managerField.getText();
            Size size = getSize(area);
            GreenSpace greenSpace = new GreenSpace(name, area, size, managerName);
            controller.registerGreenSpace(name, area, size, managerName);
            greenSpaceRepository.addGreenSpace(greenSpace);
            greenSpaceListView.getItems().add(greenSpace);
            controller.getGreenSpaceRepository().addGreenSpace(greenSpace);
            nameField.clear();
            areaField.clear();
            managerField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input for duration
            System.out.println("Invalid input for duration");
        }
    }
    public Size getSize(double area) {
        if (area > 0) {
            if (area < 50.0) {
                return Size.Garden;
            } else if (area <= 200.0) {
                return Size.Medium_Size;
            } else {
                return Size.Large_Size;
            }
        } else {
            throw new NumberFormatException("Area must be a positive integer");
        }
    }

    @FXML
    protected void handleNEXT (ActionEvent event) {
        try {
            // Load the FXML file for the AssignTeamPage
            Parent assignTeamPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GSMUI.fxml")));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the AssignTeamPage
            Scene scene = new Scene(assignTeamPage);

            // Set the scene of the current stage to the new scene
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
