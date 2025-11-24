package controllers;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ViewsChoice;

public class ChoiceController {

    Stage main_stage;
    DatasController datas;
    ViewsChoice scene;

    public ChoiceController(Stage stage){

        //Set the controllers
        this.datas = new DatasController();

        //Set the new stage
        this.main_stage = stage;
        this.main_stage.setTitle("Tower Castle");

        //Set the records in function of the data from the datacontroller
        HBox records_part = new HBox();

        JSONArray records_data = this.datas.getRecords();
        for (int i = 0; i < 3; i++) {

            JSONObject records = records_data.getJSONObject(i);
            Text name_record = new Text();
            Text level = new Text();

            if (!records.isNull("name")){
                name_record.setText(records.getString("name"));
                String level_int = records.getInt("level") + "";
                level.setText(level_int);
            }

            records_part.getChildren().add(name_record);
            records_part.getChildren().add(level);
        }

        //Set the button to start a game
        Button start = new Button();
        if (datas.setActualGame().getLevel()==0) {
            start = new Button("Start a new Game");
        }
        else {
            start = new Button("Continue the Game");
        }

        //Set the button to reset the actual game
        Button reset = new Button("Reset the Game");

        //Set the button to exit
        Button exit = new Button("Exit");

        //Set the views and his actions
        this.scene = new ViewsChoice(400,400,records_part,start,reset,exit);

    }

    public void show_Views(){
        this.main_stage.setScene(this.scene.getScene());
        this.main_stage.show();
    }

}
