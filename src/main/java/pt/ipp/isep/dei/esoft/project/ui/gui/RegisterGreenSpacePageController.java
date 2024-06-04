package pt.ipp.isep.dei.esoft.project.ui.gui;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

public class RegisterGreenSpacePageController {
    @FXML
    private ListView<GreenSpace> GreenSpaceListView;

    private final RegisterGreenSpaceController greenSpaceController;

    @FXML
    private TextField nameField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField emailField;

    private Size size;

    public RegisterGreenSpacePageController() {
        this.greenSpaceController = new RegisterGreenSpaceController();
        this.GreenSpaceListView = new ListView<GreenSpace>();
        GreenSpaceRepository greenSpaceRepository = new GreenSpaceRepository();
    }

    @FXML
    protected void registerGreenSpace() {
        try {
            // Get area
            double area = requestArea();

            // Get name and email
            String name = nameField.getText();
            String email = emailField.getText();

            // Create a new GreenSpace object
            GreenSpace greenSpace = new GreenSpace(name, area, size, email);

            // Register the green space using the controller
            greenSpaceController.registerGreenSpace(name, area, size, email);

            GreenSpaceListView.getItems().add(greenSpace);


            // Clear input fields
            nameField.clear();
            areaField.clear();
            emailField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input for area
            System.out.println("Invalid input for area");
        }
    }

    public double requestArea() {
        boolean isValid = false;
        double area = 0;

        try {
            area = Double.parseDouble(areaField.getText());
            if (area > 0) {
                isValid = true;
                if (area < 50.0) {
                    size = Size.Garden;
                } else if (area <= 200.0) {
                    size = Size.Medium_Size;
                } else {
                    size = Size.Large_Size;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for area");
        }

        if (!isValid) {
            throw new NumberFormatException();
        }

        return area;
    }
}
