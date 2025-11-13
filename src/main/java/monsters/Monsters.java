package main.java.monsters;
/*
 Represents a class Monsters with 
 */
public abstract class Monsters {

    //Information of the monsters
    
    double atq;
    double def;
    double hp;
    double speed;

    String name;

    String weakness;

    //Type will impact the stats of the monsters but more the weakness
    String type;
    
    //Return the statistiques of the monster
    public double [] getStatistics(){
        double [] statistiques = {atq,def,hp,speed};
        return statistiques;
    }

    //Return the informations of the monster
    public String [] getInformations(){
        String [] informations={name,weakness,type};
        return informations;
    }

    //Set the name of the monster
    public void setName(String name){
        this.name = name;
    }
}