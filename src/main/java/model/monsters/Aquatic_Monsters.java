package model.monsters;

import java.util.Random;

import model.Stats;

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

        int atq = r.nextInt(level_min+2,level_max+3);
        int hp = r.nextInt(level_min,level_max-4);
        int speed = r.nextInt(level_min,level_max);
        int def = r.nextInt(level_min+2,level_max+3);

        this.statistiques = new Stats(hp, atq, def, speed);
    }

}
