package model.factory;

import model.Stats;
import model.monsters.Aquatic_Monsters;
import model.monsters.Monsters;
import model.monsters.Terrestrial_Monsters;
import model.talent.Talent;

public class MonstersFactory {
    public Monsters getNewMonsters(String choix, int level){
        switch (choix) {
            case "aquatic":
                return new Aquatic_Monsters(level+10, level);

            case "terrestrial":
                return new Terrestrial_Monsters(level+10, level);

            case "air":
                return new Terrestrial_Monsters(level+10, level);

            default:
                return new Terrestrial_Monsters(level, level);
        }
    }

    public Monsters getMonsters(String type, Stats stats, Talent talent, String name){
        switch (type) {
            case "aquatic":
                return new Aquatic_Monsters(stats,name,talent);

            case "terrestrial":
                return new Terrestrial_Monsters(stats,name,talent);

            case "air":
                return new Terrestrial_Monsters(stats,name,talent);
            
            default :
                return new Terrestrial_Monsters(stats, name, talent);
        }
    }

}
