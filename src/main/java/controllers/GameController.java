package controllers;

import java.util.ArrayList;

import model.Stats;
import model.cards.Cards;
import model.monsters.Aquatic_Monsters;
import model.monsters.Monsters;
import model.monsters.Terrestrial_Monsters;
import model.talent.Talent;

public class GameController {

    /*The game had the level of the game, the monsters and the cards */

    private Monsters monsters;
    private int level;
    private ArrayList<Cards> cards;

    public GameController(String choix){
        this.level=0;
        switch (choix) {

            case "aquatic":
                this.monsters = new Aquatic_Monsters(level+10, level);
                break;

            case "terrestrial":
                this.monsters = new Terrestrial_Monsters(level+10, level);
                break;

            case "air":
                this.monsters = new Terrestrial_Monsters(level+10, level);
                break;

            default:
                break;
        }
        new TalentController(this.monsters);
    }

    public GameController(String type,String name, Talent talent, Stats stats, int level, ArrayList<Cards> cards_game){
        this.level = level;
        this.cards = cards_game;
        switch (type) {
            case "aquatic":
                this.monsters = new Aquatic_Monsters(stats,name,talent);
                break;

            case "terrestrial":
                this.monsters = new Terrestrial_Monsters(stats,name,talent);
                break;

            case "air":
                this.monsters = new Terrestrial_Monsters(stats,name,talent);
                break;
        }
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
