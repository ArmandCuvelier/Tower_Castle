package controllers;

import java.util.Random;

import model.monsters.Monsters;
import model.talent.Agressive;
import model.talent.Flash;
import model.talent.Passive;
import model.talent.Talent;

public class TalentController {

    /*The controller choose aleatory the talent of the pokemon*/

    public TalentController(Monsters monsters){
        monsters.setTalent(this.getChooseTalent());
    }

    public Talent getChooseTalent(){
        Random r = new Random();
        Talent talent;
        switch (r.nextInt(0)) {

            case 1:
                talent = new Agressive();
                break;
            
            case 2:
                talent = new Flash();
                break;
        
            default:
                talent = new Passive();
                break;

        }
        return talent;
    }
}
