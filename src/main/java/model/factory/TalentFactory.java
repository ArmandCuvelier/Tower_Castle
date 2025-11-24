package model.factory;

import org.json.JSONObject;

import model.talent.Agressive;
import model.talent.Flash;
import model.talent.Passive;
import model.talent.Talent;

public class TalentFactory {
    public Talent getTalent(JSONObject monsters){
        switch (monsters.getString("talent")) {
            case "flash":
                return new Flash();
            case "agressive":
                return new Agressive();
            case "passive":
                return new Passive();
            default:
                return new Passive();
        }
    }
}
