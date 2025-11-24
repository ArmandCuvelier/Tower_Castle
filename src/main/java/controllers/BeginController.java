package controllers;

import javafx.scene.control.Button;
import javafx.stage.*;
import views.ViewsBegin;

public class BeginController {

    Stage main_stage;
    ViewsBegin scene_begin;

    public BeginController(Stage primaryStage){

        //Set the stage
        this.main_stage = primaryStage;
        this.main_stage.setTitle("Tower Castle");

        //Create the the button and the effect for the views
        Button start = new Button("Start the game");
        start.setOnAction(e -> show_Choice());
        this.scene_begin = new ViewsBegin(400,400,start);
        
    }

    public void show_View(){
        this.main_stage.setScene(scene_begin.getScene());
        this.main_stage.show();
    }

    public void show_Choice(){
        new ChoiceController(this.main_stage).show_Views();
    }

}
