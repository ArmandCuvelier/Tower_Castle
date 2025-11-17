package views;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import java.net.URL;

public class ViewsBegin {

    private Scene scene_main;

    public ViewsBegin(double width, double height){

        //Set the root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        //Logo
        URL logoUrl = getClass().getResource("/assets/pictures/Design.png");
        if (logoUrl != null) {
            Image logo = new Image(logoUrl.toExternalForm());
            Canvas canvas = new Canvas(width/2, height/4);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.drawImage(logo, 0, 0, canvas.getWidth(), canvas.getHeight());
            root.getChildren().add(canvas);
        } else {
            System.out.println("Logo not found");
        }

        //Button start
        Button start = new Button("Start the game");
        start.setMaxHeight(height/8);
        start.setMaxWidth(width/2);
        root.getChildren().add(start);

        //Set the scene
        this.scene_main = new Scene(root, width, height);
        URL cssUrl = getClass().getResource("/style/ViewsBegin.css");
        if (cssUrl != null) {
            scene_main.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.out.println("CSS not found");
        }
    }

    //Return the scene for the controlleur
    public Scene getScene(){
        return scene_main;
    }
}