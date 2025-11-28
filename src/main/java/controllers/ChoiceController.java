package controllers;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        VBox records_part = new VBox(10);
        records_part.setAlignment(Pos.CENTER);

        JSONArray records_data = this.datas.getRecords();
        for (int i = 0; i < records_data.length() && i < 3; i++) {

            JSONObject records = records_data.getJSONObject(i);
            
            if (!records.isNull("name")){
                HBox record_line = new HBox(30);
                record_line.setAlignment(Pos.CENTER);
                
                Text name_record = new Text(records.getString("name"));
                name_record.getStyleClass().add("name");
                
                Text level = new Text(String.valueOf(records.getInt("level")));
                level.getStyleClass().add("level");
                
                record_line.getChildren().addAll(name_record, level);
                records_part.getChildren().add(record_line);
            }
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
