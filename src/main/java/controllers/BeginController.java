package controllers;

import javafx.scene.control.Button;
import javafx.stage.*;
import views.ViewsBegin;
import views.ViewsChoice;

public class BeginController {

    Stage main_stage;
    DatasController datas;
    ViewsBegin scene_begin;
    ViewsChoice scene_choice;

    public BeginController(Stage primaryStage){

        //Set the controllers
        this.datas = new DatasController();

        //Set the stage
        this.main_stage = primaryStage;
        this.main_stage.setTitle("Tower Castle");

        //Create the the button and the effect for the views
        Button start = new Button("Start the game");
        start.setOnAction(e -> show_Begin_Choice());
        this.scene_begin = new ViewsBegin(400,400,start);
        
    }

    public void show_Begin_View(){
        main_stage.setScene(scene_begin.getScene());
        main_stage.show();
    }

    public void show_Begin_Choice(){
        this.scene_choice = new ViewsChoice(400,400);
        main_stage.setScene(scene_choice.getScene());
        main_stage.show();
    }

}
