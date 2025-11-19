package model.talent;

import model.Stats;

public class Flash implements Talent {

    /*
     * Flash is a talent who boost the spd of the pokemon by 3
     * but drop by 1 the hp
     * at the start of every fight
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
        stats.setSpd(stats.getSpd()+3);
        stats.setHp(stats.getHp()-1);
    }

}
