package model.monsters;

import java.util.Random;

import model.Stats;

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

        int atq = r.nextInt(level_min+2,level_max+3);
        int hp = r.nextInt(level_min,level_max);
        int speed = r.nextInt(level_min+2,level_max+3);
        int def = r.nextInt(level_min,level_max-4);

        this.statistiques = new Stats(hp, atq, def, speed);
    }

}
