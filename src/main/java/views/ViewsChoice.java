package views;

import java.net.URL;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class ViewsChoice {

    private Scene scene_main;

    public ViewsChoice(double width, double height){

            //Set the root
            VBox root = new VBox();
            root.setAlignment(Pos.CENTER);

            //Section of the records
            VBox records_root = new VBox();
            Text titre_records = new Text("RECORDS");
            
            //The record are a line with
            for (int i = 0; i < 3; i++) {
                HBox records_part = new HBox();
                Text name_record = new Text("Null");
                Text level = new Text("Null");
                records_part.getChildren().add(name_record);
                records_part.getChildren().add(level);
                records_root.getChildren().add(records_part);
            }


            root.getChildren().add(titre_records);
            root.getChildren().add(records_root);
            

            //Set the scene
            this.scene_main = new Scene(root, width, height);
            URL cssUrl = getClass().getResource("/style/ViewsChoice.css");
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
