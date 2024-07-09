package ajay123.LoginSignup;

import java.util.HashMap;
import java.util.Map;

import ajay123.Controller.FormNavigation;
import ajay123.Firebase.DataService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SignUpController {
    private FormNavigation app;
    private GridPane view;
    private DataService dataService;

    public SignUpController(FormNavigation app) {
        this.app = app;
        this.dataService = new DataService(); // Initialize DataService

        initialize();
    }

    private void initialize() {
        view = new GridPane();
        Label userLabel = new Label("Username:");
        TextField userTextField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button signupButton = new Button("Signup");

        VBox fieldBox1 = new VBox(10, userLabel, userTextField);
        fieldBox1.setMaxSize(300, 30);

        VBox fieldBox2 = new VBox(10, passLabel, passwordField);
        fieldBox2.setMaxSize(300, 30);

        HBox buttonBox = new HBox(50, signupButton);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.CENTER);

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userTextField.getText();
                String password = passwordField.getText();
                handleSignup(username, password);
            }
        });

        VBox vbox = new VBox(20, fieldBox1, fieldBox2, buttonBox);
        vbox.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("Images\\Login-SignUp\\FURNIFLEX.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(1300);
        backgroundView.setFitHeight(1200);
        backgroundView.setPreserveRatio(true);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, vbox);
        view.add(root, 0, 0);
    }

    private void handleSignup(String username, String password) {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("username", username);
            data.put("password", password);

            // Add data to DataService
            dataService.addData("users", username, data);

            System.out.println("User registered successfully");

            // Navigate to page 4
            app.navigateTopage4();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Parent getView() {
        return view;
    }
}
