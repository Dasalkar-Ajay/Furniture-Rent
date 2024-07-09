package ajay123.Homepage;

import ajay123.Controller.FormNavigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomePage {
    private FormNavigation app;
    private GridPane view;

    public HomePage(FormNavigation app) {
        this.app = app;
        initialize();

    }

    private void initialize() {
        view = new GridPane();

        // Load background image
        Image backgroundImage = new Image("Images\\HomePage\\Furniture image.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(2800); // Set the width to fit the window
        backgroundView.setFitHeight(1200); // Set the height to fit the window
        backgroundView.setPreserveRatio(true);

        // Create slogan text
        Text description = new Text("Great furniture can bring Beauty at your home,");
        description.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-fill:Black");

        Text des = new Text("so buy our popular and stylish furniture");
        des.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-fill:Black");

        Text slogan = new Text("The Furniture That Reflect Your Style");
        slogan.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-fill:Black");

        // Create Explore button
        Button exploreButton = new Button("Explore");
        exploreButton.setStyle("-fx-font-size: 25px; -fx-padding: 15px 20px;-fx-font-weight:Bold");
        exploreButton.setFont(new Font(40));

        exploreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                app.navigateTopage3();

            }

        });

        // create signin ,login, contact us button
        Button signin = new Button("Sign up");
        signin.setStyle(
                "-fx-background-color:yellow; -fx-font-size: 15px; -fx-padding: 15px 15px;-fx-font-weight:Bold");
        signin.setFont(new Font(40));

        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.navigateTopage3();

            }

        });

        // Login button
        Button login = new Button("Login");
        login.setStyle(
                "-fx-background-color:Yellow; -fx-font-size: 15px; -fx-padding: 15px 15px; -fx-font-weight:Bold");
        login.setFont(new Font(40));

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.navigateTopage3();
            }

        });

        // About Us contact Button

        Button contactus = new Button("contact us");
        contactus.setStyle(
                "-fx-background-color:Yellow; -fx-font-size: 15px; -fx-padding: 15px 15px; -fx-font-weight:Bold");
        contactus.setFont(new Font(40));
        contactus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        // Layout for slogan and button
        VBox vbox = new VBox(30, slogan, description, des, exploreButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-alignment: topcenter; -fx-padding: 50;");

        // Layout for signin , contact us , login
        HBox hBox = new HBox(100, signin, login, contactus);
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.setStyle("-fx-alignment: topcenter; -fx-padding: 50;");

        // StackPane to overlay text and button over the image
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, vbox, hBox);

        view.add(root, 0, 0);

    }

    public GridPane getview() {
        return view;
    }

}