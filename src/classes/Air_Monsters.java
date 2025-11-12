package classes;

import java.util.Random;

/*
 * Represents a Air Monster who herits of Monster
 * His type will be Air
 */

public class Air_Monsters extends Monsters {

    /*
    *Create a Monster with the statistics of the type AIR
    *who impact the statistics
    */
    public Air_Monsters(int level_max,int level_min){
        Random r = new Random();

        this.type = "air";
        this.weakness = "aquatic";

        this.atq = r.nextDouble(level_min+2,level_max+3);
        this.hp = r.nextDouble(level_min,level_max);
        this.speed = r.nextDouble(level_min+2,level_max+3);
        this.def = r.nextDouble(level_min,level_max-4);
    }

}
