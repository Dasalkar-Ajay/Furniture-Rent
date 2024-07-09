package ajay123.LoginSignup;

import java.util.concurrent.ExecutionException;

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

public class LoginController {

    private FormNavigation app;
    private GridPane view;
    private DataService dataService;
    public static String key;

    public LoginController(FormNavigation app) {
        this.app = app;
        dataService = new DataService();
        initialize();
    }

    private void initialize() {
        view = new GridPane();

        Label userLabel = new Label("username"); // Corrected typo: "username" instead of "userneme"
        TextField userTextField = new TextField();
        Label passLabel = new Label("password");
        PasswordField passField = new PasswordField();

        Button loginButton = new Button("login");
        Button signUpButton = new Button("SignUp");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin(userTextField.getText(), passField.getText());
                userTextField.clear();
                passField.clear();
                app.navigateTopage5(); // Commented out because of unclear purpose
            }
        });

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userTextField.clear();
                passField.clear();
                app.navigateTopage3(); // Commented out because of unclear purpose
            }
        });

        userLabel.setStyle("-fx-text-fill:white");
        passLabel.setStyle("-fx-text-fill:white");

        VBox fieldBox1 = new VBox(10, userLabel, userTextField);
        VBox fieldBox2 = new VBox(10, passLabel, passField);

        fieldBox1.setMaxSize(300, 30);
        fieldBox2.setMaxSize(300, 30);

        HBox buttonBox = new HBox(50, loginButton, signUpButton);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.CENTER);

        userTextField.setPrefWidth(350); // Corrected style setting
        passField.setPrefWidth(350); // Corrected style setting

        VBox vbox = new VBox(20, fieldBox1, fieldBox2, buttonBox);
        vbox.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("Images/Login-SignUp/FURNIFLEX.jpg"); // Corrected path separator
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(1300); // Set the width to fit the window
        backgroundView.setFitHeight(1200); // Set the height to fit the window
        backgroundView.setPreserveRatio(true);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, vbox);

        // Adding the root to the view (assuming this is where it should be added)
        view.add(root, 0, 0);
    }

    private void handleLogin(String username, String password) {
        try {
            if (dataService.authenticateUser(username, password)) {
                key = username;
                System.out.println(username);
                System.out.println(password);
                app.navigateTopage5(); // Assuming this should navigate to page 5 upon successful login
            } else {
                System.out.println("Invalid credentials");
            }
            key = null; // This line might need revision based on intended logic
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public Parent getView() {
        return view; // Added a getter for the view, assuming it's needed to display the UI
    }
}
