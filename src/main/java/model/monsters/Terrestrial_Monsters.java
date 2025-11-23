package model.monsters;

import java.util.Random;

import model.Stats;
import model.talent.Talent;

/*
 * Represents a Aquatic Monster who herits of Monster
 * His type will be Aquatic
 */

public class Terrestrial_Monsters extends Monsters {

    /*
    *Create a Monster with the statistics of the type Aqua
    *who impact the statistics
    */
    public Terrestrial_Monsters(int level_max,int level_min){
        Random r = new Random();

        this.type = "terrestrial";
        this.weakness = "air";

        int atq = r.nextInt(level_min+2,level_max+3);
        int hp = r.nextInt(level_min+2,level_max+3);
        int speed = r.nextInt(level_min,level_max-3);
        int def = r.nextInt(level_min,level_max);

        this.statistiques = new Stats(hp, atq, def, speed);
    }

    public Terrestrial_Monsters(Stats statistiques,String name, Talent talent){
        this.statistiques = statistiques;
        this.name = name;
        this.talent = talent;
        this.weakness = "air";
    }


}
