package model.monsters;

import java.util.Random;

/*
 * Represents a Aquatic Monster who herits of Monster
 * His type will be Aquatic
 */

public class Aquatic_Monsters extends Monsters {

    /*
    *Create a Monster with the statistics of the type Aqua
    *who impact the statistics
    */
    public Aquatic_Monsters(int level_max,int level_min){
        Random r = new Random();

        this.type = "aquatic";
        this.weakness = "terrestrial";

        this.atq = r.nextDouble(level_min+2,level_max+3);
        this.hp = r.nextDouble(level_min,level_max-4);
        this.speed = r.nextDouble(level_min,level_max);
        this.def = r.nextDouble(level_min+2,level_max+3);
    }

}
