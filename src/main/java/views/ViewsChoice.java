package views;

import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class ViewsChoice {

    private Scene scene_main;

    public ViewsChoice(double width, double height, VBox records_part, Button start, Button reset, Button exit){

            //Set the root
            VBox root = new VBox(40);
            root.setAlignment(Pos.CENTER);
            root.setPadding(new Insets(30));

            //Section of the records
            VBox records_root = new VBox(20);
            records_root.setAlignment(Pos.CENTER);

            Text titre_records = new Text("RECORDS");
            titre_records.getStyleClass().add("title");

            records_root.getChildren().add(titre_records);
            records_part.setAlignment(Pos.CENTER);
            records_part.setSpacing(50);
            records_root.getChildren().add(records_part);

            root.getChildren().add(records_root);

            //Section of the actions for the games
            HBox actions_game = new HBox(30);
            actions_game.setAlignment(Pos.CENTER);
            start.getStyleClass().add("button");
            reset.getStyleClass().add("button");
            actions_game.getChildren().add(start);
            actions_game.getChildren().add(reset);
            
            root.getChildren().add(actions_game);

            //Section for the bonus actions
            VBox actions_bonus = new VBox(30);
            actions_bonus.setAlignment(Pos.CENTER);
            exit.getStyleClass().add("button");
            actions_bonus.getChildren().add(exit);

            root.getChildren().add(actions_bonus);

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
