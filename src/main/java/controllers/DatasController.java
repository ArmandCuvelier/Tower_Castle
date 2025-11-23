package controllers;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Stats;
import model.cards.Cards;
import model.cards.Hares;
import model.cards.Hygie;
import model.talent.Agressive;
import model.talent.Flash;
import model.talent.Passive;
import model.talent.Talent;

public class DatasController {

    private GameController main_game;

    public DatasController(){
        setActualGame();
    }

    public void setActualGame(){
        try {
            InputStream is = getClass().getResourceAsStream("/Curentgame.json");

            if (is == null) {
                System.out.println("Open of the data for the game is not possible");
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject data = new JSONObject(content);

            if (data.has("level") && !data.isNull("level")){

                JSONArray monsters_info = data.getJSONArray("monsters");
                JSONArray cards_info = data.getJSONArray("cards");

                ArrayList<Cards> cards_game = new ArrayList<>();
                for (int i = 0; i < cards_info.length(); i++) {

                    JSONObject cardJson = cards_info.getJSONObject(i);
                    String nameCard = cardJson.getString("nameCard");
                    int rarity = cardJson.getInt("rarity");
                    switch (nameCard) {
                        case "hares":
                            cards_game.add(new Hares(rarity, false));
                            break;
                    
                        case "hygie":
                            cards_game.add(new Hygie(rarity, false));
                            break;
                        
                        default :
                            break;
                    }

                }

                JSONObject monsters = monsters_info.getJSONObject(0);
                Stats statistiques = new Stats(monsters.getInt("hp"), monsters.getInt("atq"), monsters.getInt("def"), monsters.getInt("spd"));
                Talent talent = new Flash();
                switch (monsters.getString("talent")) {

                    case "flash":
                        talent = new Flash();
                        break;

                    case "agressive":
                        talent = new Agressive();
                        break;

                    case "passive":
                        talent = new Passive();
                        break;
                }

                this.main_game = new GameController(monsters.getString("type"), data.getString("name"), talent, statistiques, data.getInt("level"), cards_game);
            }
            
        } catch (Exception e) {
            System.out.println("Open of the data for the actual Game is not possible");
        }
    }

    public JSONArray getRecords() {
        try {
            InputStream is = getClass().getResourceAsStream("/Records.json");

            if (is == null) {
                System.out.println("Open of the data for the records is not possible");
                return new JSONArray();
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject data = new JSONObject(content);
            JSONArray records = new JSONArray();

            records.put(data.getJSONObject("record1"));
            records.put(data.getJSONObject("record2"));
            records.put(data.getJSONObject("record3"));
            return records;

        }
        catch (Exception e) {
            System.out.println("Read of the data for the records is not possible");
            return new JSONArray();
        }
    }

    public GameController getGameController(){
        return this.main_game;
    }
}
