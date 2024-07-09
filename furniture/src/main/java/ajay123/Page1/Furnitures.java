package ajay123.Page1;

import ajay123.Controller.FormNavigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Furnitures {

    private GridPane view;
    private FormNavigation app;

    public Furnitures(FormNavigation app) {

        this.app = app;
        initialize();
    }

    private void initialize() {
        view = new GridPane();

        // create a label for Explore collection
        Label lb = new Label("EXPLORE OUR COLLECTION");
        lb.setFont(new Font(30));
        lb.setAlignment(Pos.TOP_CENTER);

        // Image of kichen & Dinning
        Image img1 = new Image("Images\\Page1\\K&D.jpg");
        ImageView iv1 = new ImageView(img1);
        iv1.setFitHeight(250);
        iv1.setFitWidth(300);

        // Image of Bedroom
        Image img2 = new Image("Images\\Page1\\Bed.jpeg");
        ImageView iv2 = new ImageView(img2);
        iv2.setFitHeight(250);
        iv2.setFitWidth(300);

        // Image of Living room
        Image img3 = new Image("Images\\Page1\\L_Room.jpg");
        ImageView iv3 = new ImageView(img3);
        iv3.setFitHeight(250);
        iv3.setFitWidth(300);

        // Image of Wadrobe
        Image img4 = new Image("Images\\Page1\\Wadrobe.jpg");
        ImageView iv4 = new ImageView(img4);
        iv4.setFitHeight(250);
        iv4.setFitWidth(300);

        // Create a button for Dinning & Kichen
        Button bt1 = new Button("Dinning & Kichen");
        bt1.setMaxSize(500, 400);
        bt1.setFont(new Font(30));
        bt1.setFont(Font.font("arial", FontWeight.BOLD, 25));
        // bt1.setStyle("-fx-backgrond-olor:black");
        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        // Create a button for Bedroom
        Button bt2 = new Button("Bedroom");
        bt2.setMaxSize(500, 400);
        bt2.setFont(new Font(30));
        bt2.setFont(Font.font("arial", FontWeight.BOLD, 25));
        bt2.setStyle("-fx-backgrond-color:black");
        bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        // Create a button for Living Room
        Button bt3 = new Button("Living Room");
        bt3.setMaxSize(500, 400);
        bt3.setFont(new Font(30));
        bt3.setFont(Font.font("arial", FontWeight.BOLD, 25));
        bt3.setStyle("-fx-backgrond-color:black");
        bt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        // Create a button for Wadrobe
        Button bt4 = new Button("Wadrobes");
        bt4.setMaxSize(500, 400);
        bt4.setFont(new Font(30));
        bt4.setFont(Font.font("arial", FontWeight.BOLD, 25));
        bt4.setStyle("-fx-backgrond-color:black");
        bt4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        // Put image and their button in VBox
        VBox vb1 = new VBox(iv1, bt1);
        VBox vb2 = new VBox(iv2, bt2);
        VBox vb3 = new VBox(iv3, bt3);
        VBox vb4 = new VBox(iv4, bt4);

        // Put two VBox in new VBOX
        VBox vbb1 = new VBox(50, vb1, vb3);
        vbb1.setMinSize(50, 50);
        VBox vbb2 = new VBox(50, vb2, vb4);

        // Put VBox in HBox
        HBox hb = new HBox(30);
        hb.getChildren().addAll(vbb1, lb, vbb2);
        hb.setAlignment(Pos.CENTER);
        // hb.setStyle("-fx-background-color:grey");

        Image backgroundImage = new Image("Images\\Page1\\Furniture image.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(1300); // Set the width to fit the window
        backgroundView.setFitHeight(1200); // Set the height to fit the window
        // backgroundView.setPreserveRatio(true);

        // Snehals code

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, hb);

        view.add(root, 0, 0);

    }

    public Parent getview() {
        return view;
    }

}