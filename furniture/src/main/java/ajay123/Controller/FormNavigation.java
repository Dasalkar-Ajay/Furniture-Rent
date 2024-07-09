package ajay123.Controller;

import ajay123.Homepage.HomePage;
import ajay123.LoginSignup.LoginController;
import ajay123.LoginSignup.SignUpController;
import ajay123.Page1.Furnitures;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormNavigation extends Application {

    private Stage primaryStage;
    private Scene page1Scene, page3Scene, page4Scene, page5Scene;

    private HomePage page1;
    private SignUpController page3;
    private LoginController page4;
    private Furnitures page5;

    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        page1 = new HomePage(this);

        page3 = new SignUpController(this);
        page4 = new LoginController(this);
        page5 = new Furnitures(this);

        page1Scene = new Scene(page1.getview(), 400, 400);
        page3Scene = new Scene(page3.getView(), 400, 400);
        page4Scene = new Scene(page4.getView(), 400, 400);
        page5Scene = new Scene(page5.getview(), 400, 400);

        primaryStage.setScene(page1Scene);
        primaryStage.setTitle("Furnimets.here");
        primaryStage.show();

    }

    public void navigateTopage1() {
        primaryStage.setScene(page1Scene);
    }

    public void navigateTopage3() {
        primaryStage.setScene(page3Scene);
    }

    public void navigateTopage4() {
        primaryStage.setScene(page4Scene);
    }

    public void navigateTopage5() {
        primaryStage.setScene(page5Scene);
    }

}
