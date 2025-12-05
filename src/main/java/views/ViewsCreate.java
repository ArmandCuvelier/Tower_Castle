package views;

import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewsCreate {

    private Scene scene_main;

    public ViewsCreate(double width, double height){

            //Set the root
            VBox root = new VBox(40);
            root.setPadding(new Insets(30));

            //Area of the main buttons
            HBox mainactionsVBox = new HBox(240);
            mainactionsVBox.setAlignment(Pos.TOP_CENTER);
            Button back = new Button("Back");
            Button play = new Button("Play");
            mainactionsVBox.getChildren().add(back);
            mainactionsVBox.getChildren().add(play);

            
            //Area of the form
            VBox form = new VBox(10);
            form.setAlignment(Pos.CENTER);
            
            // Area for the name
            VBox text_form = new VBox(10);
            Text title = new Text("Name :");
            TextArea name = new TextArea();
            name.setMaxHeight(height/8);
            text_form.getChildren().add(title);
            text_form.getChildren().add(name);

            //Area for the choice of the type's monsters

            //Containers
            VBox choice_type = new VBox(10);
            choice_type.setAlignment(Pos.BOTTOM_CENTER);
            HBox type_possibility = new HBox(5);
            type_possibility.setAlignment(Pos.CENTER);

            //Elements
            Text title_type = new Text("Type of the monsters");
            Button air = new Button("Air");
            Button aquatic = new Button("Aquatic");
            Button terrestrial = new Button("Terrestrial");
            Button aleatory = new Button("Aleatory");

            //Assembly
            choice_type.getChildren().add(title_type);
            type_possibility.getChildren().add(air);
            type_possibility.getChildren().add(aquatic);
            type_possibility.getChildren().add(terrestrial);
            choice_type.getChildren().add(type_possibility);
            choice_type.getChildren().add(aleatory);

            //Assembly of the element of the form
            form.getChildren().add(text_form);
            form.getChildren().add(choice_type);

            //Assembly in the root
            root.getChildren().add(mainactionsVBox);
            root.getChildren().add(form);

            //Set the scene
            this.scene_main = new Scene(root, width, height);
            URL cssUrl = getClass().getResource("/style/ViewsCreate.css");
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
