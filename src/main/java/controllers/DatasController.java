package controllers;

import org.json.JSONArray;

public class DatasController {

    //records contains the 3 best game in order by level
    private JSONArray records ;

    //currentGame contains the information about the player, his monster (stats,talents,type) and his cards
    private JSONArray currentGame ;

    public DatasController(){
        this.records = new JSONArray(3);
        this.currentGame = new JSONArray();
    }

}
