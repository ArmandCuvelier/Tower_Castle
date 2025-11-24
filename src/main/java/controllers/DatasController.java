package controllers;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Stats;
import model.cards.Cards;
import model.factory.CardsFactory;
import model.factory.TalentFactory;
import model.talent.Talent;

public class DatasController {

    public DatasController(){
        setActualGame();
    }

    /*Return a gamecontroller defined by the data */
    public GameController setActualGame(){

        //Test the opening/reading of the files
        try {
            InputStream is = getClass().getResourceAsStream("/Curentgame.json");

            if (is == null) {
                System.out.println("Open of the data for the game is not possible");
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject data = new JSONObject(content);

            //If level is not null -> a game exists 
            if (data.has("level") && !data.isNull("level")){

                JSONArray monsters_info = data.getJSONArray("monsters");
                JSONArray cards_info = data.getJSONArray("cards");

                ArrayList<Cards> cards_game = new ArrayList<>();
                for (int i = 0; i < cards_info.length(); i++) {

                    JSONObject cardJson = cards_info.getJSONObject(i);
                    String nameCard = cardJson.getString("nameCard");
                    int rarity = cardJson.getInt("rarity");
                    cards_game.add(new CardsFactory().getCards(nameCard, rarity));

                }

                JSONObject monsters = monsters_info.getJSONObject(0);
                Stats statistiques = new Stats(monsters.getInt("hp"), monsters.getInt("atq"), monsters.getInt("def"), monsters.getInt("spd"));
                Talent talent = new TalentFactory().getTalent(monsters);

                return new GameController(monsters.getString("type"), data.getString("name"), talent, statistiques, data.getInt("level"), cards_game);
            }
            return new GameController(null, 0, null);
            
        } catch (Exception e) {
            System.out.println("Open of the data for the actual Game is not possible");
        }
        return new GameController(null, 0, null);
    }

    //Return the 3 records
    public JSONArray getRecords() {

        //Try the opening/reading of the files
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
}
