package model.monsters;

import model.Stats;
import model.talent.Talent;

/*
 Represents a class Monsters with 
 */
public abstract class Monsters {

    //Information of the monsters
    
    protected Stats statistiques;

    protected String name;

    protected String weakness;

    //Type will impact the stats of the monsters but more the weakness
    protected String type;

    //Talent impact at a time the stats of the monsters
    protected Talent talent;

    //Return the informations of the monster
    public String [] getInformations(){
        String [] informations={name,weakness,type};
        return informations;
    }

    //Set the name of the monster
    public void setName(String name){
        this.name = name;
    }

    public void setTalent(Talent talent_def){
        this.talent = talent_def;
    }

    public Stats getStatistiques(){
        return this.statistiques;
    }

    public void setStatistiques(Stats statistiques){
        this.statistiques = statistiques;
    }
}