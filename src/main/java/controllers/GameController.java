package controllers;

import java.util.ArrayList;

import model.Stats;
import model.cards.Cards;
import model.factory.MonstersFactory;
import model.monsters.Monsters;
import model.talent.Talent;

public class GameController {

    /*The game had the level of the game, the monsters and the cards */

    private Monsters monsters;
    private int level;
    private ArrayList<Cards> cards;

    public GameController(String choix){
        this.level=0;
        this.monsters = new MonstersFactory().getNewMonsters(choix, this.level);
        new TalentController(this.monsters);
    }

    public GameController(String type,String name, Talent talent, Stats stats, int level, ArrayList<Cards> cards_game){
        this.level = level;
        this.cards = cards_game;
        this.monsters = new MonstersFactory().getMonsters(type, stats, talent, name);
    }

    public GameController(Monsters monsters, int level, ArrayList<Cards> cards_game){
        this.level = level;
        this.monsters = monsters;
        this.cards = cards_game;
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
