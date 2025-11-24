import controllers.BeginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Tower_Castle extends Application {

    @Override
    public void start(Stage primaryStage) {
        new BeginController(primaryStage).show_View();
    }

    public static void main(String[] args) {
        launch(args);
    }
}