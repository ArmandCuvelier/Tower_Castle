package model.talent;

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
    public double[] effet_talent(double[] stats){
        stats[3]+=3;
        stats[2]-=1;
        return stats;
    }

}
