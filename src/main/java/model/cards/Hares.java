package model.cards;

import java.util.Random;

import model.Stats;
import model.monsters.Monsters;

public class Hares extends Cards{

    /* The constructor creates a card Hares who :
    * are an assets
    * boost the spd and the atq by a number who depends on the rarity at the half way and end of the round
    * The rarity is defined by the level accomplished and luck
    */
    public Hares(int level){
        this.name = "Hares";
        this.type = "assets";

        //Value of the rarity
        Random luck = new Random();
        if (level%10==0){
            this.rarity = 5;
        }
        else {
            if (level%5==0){
                this.rarity = 3;
            }
            else {
                this.rarity = 1;
            }
            if (luck.nextInt(1, 10)>8){
                this.rarity+=2;
            }
        }
    }

    //The bonus of atq and spd depends of the rarity
    @Override
    public void geteffet(Monsters monsters, int level){
        if (level%5 == 0){
            Stats statistiques = monsters.getStatistiques();
            int bonus = 1;

            //Value of the bonus
            switch (this.rarity) {
                case 3:
                    bonus = 2;
                    break;
                
                case 5:
                    bonus = 3;
                    break;
                default:
                    break;
            }

            statistiques.setSpd(statistiques.getSpd()+bonus);
            statistiques.setAtq(statistiques.getAtq()+bonus);
            monsters.setStatistiques(statistiques);
        }
    }
}
