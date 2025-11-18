package controllers;

import java.util.Hashtable;

public class DatasController {

    //records contains the 3 best game in order by level
    private Hashtable records ;

    //currentGame contains the information about the player, his monster (stats,talents,type) and his cards
    private Hashtable currentGame ;

    public DatasController(){
        this.records = new Hashtable<>(3);
        this.currentGame = new Hashtable<>();
    }
}
