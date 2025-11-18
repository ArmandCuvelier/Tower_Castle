import controllers.BeginControlleur;
import javafx.application.Application;
import javafx.stage.Stage;

public class Tower_Castle extends Application {

    @Override
    public void start(Stage primaryStage) {
        new BeginControlleur(primaryStage).show_Begin_View();
    }

    public static void main(String[] args) {
        launch(args);
    }
}