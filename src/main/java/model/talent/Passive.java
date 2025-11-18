package model.talent;

public class Passive implements Talent {

    /*
     * Passive is a talent who boost the def and the hp of the pokemon by 1 
     * at the begining of every fight
     */

    private String name = "passive";
    private String time = "start";

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    //Stats contains in order : atq,def,hp,speed of the monsters
    public double[] effet_talent(double[] stats){
        stats[1]+=1;
        stats[2]+=1;
        return stats;
    }

}
