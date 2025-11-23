package model;

import java.util.ArrayList;

import model.cards.Cards;
import model.monsters.Monsters;

public class Game {

    private Monsters monsters;
    private int level;
    private ArrayList<Cards> cards;

    public Game(String choix){
        this.level=0;
    }

    public Monsters getMonsters(){
        return this.monsters;
    }

    public int getLevel(){
        return this.level;
    }

    public void indentationLevel(){
        this.level+=1;
    }

    public ArrayList<Cards> getCards(){
        return this.cards;
    }
}
