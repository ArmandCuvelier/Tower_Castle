package model.cards;

import model.monsters.Monsters;

public abstract class Cards {
    
    String name;

    /* Type of a cards is the rarity of them :
    * 1 -> 1 stars
    * 3 -> 3 stars
    * 5 -> 5 stars
    */
    int rarity;

    /* Type can correspond to values :
    * Assets -> 
    * Consummable
    */
    String type;

    public void geteffet(Monsters monsters, int level){

    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getRarity(){
        return this.rarity;
    }
}
