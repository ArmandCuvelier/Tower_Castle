package model.talent;

import model.Stats;

public class Agressive implements Talent {

    /*
     * Agressive is a talent who boost the atq of the pokemon by 2
     * at the end of every fight
     */

    private String name = "agressive";
    private String time = "end";

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    //Stats contains in order : atq,def,hp,speed of the monsters
    public void effet_talent(Stats stats){
        stats.setAtq(stats.getAtq()+1);
    }

}
