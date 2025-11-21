package model.cards;

import java.util.Random;

import model.Stats;
import model.monsters.Monsters;

public class Hygie extends Cards{

    /* The constructor creates a card Hygie who :
    * are an consummable
    * boost the hp by a number who depends on the rarity
    * The rarity is defined by the level accomplished and luck
    */
    public Hygie(int level){
        this.name = "Hygie";
        this.type = "consummable";

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
            if (luck.nextInt(1, 10)>7){
                this.rarity+=2;
            }
        }
    }

    //The bonus of hp depends of the rarity
    @Override
    public void geteffet(Monsters monsters, int level){
        Stats statistiques = monsters.getStatistiques();
        int bonus = 1;

        //Value of the bonus
        switch (this.rarity) {
            case 3:
                bonus = 3;
                break;
            
            case 5:
                bonus = 6;
                break;
            default:
                break;
        }

        statistiques.setHp(statistiques.getHp()+bonus);
        monsters.setStatistiques(statistiques);
    }
}
