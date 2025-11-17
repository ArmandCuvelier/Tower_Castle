import javafx.application.Application;
import javafx.stage.Stage;
import views.ViewsBegin;

public class Tower_Castle extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new ViewsBegin(400,400).getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}