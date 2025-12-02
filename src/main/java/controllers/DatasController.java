package controllers;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Stats;
import model.cards.Cards;
import model.factory.CardsFactory;
import model.factory.TalentFactory;
import model.talent.Talent;

public class DatasController {

    private final File dataFolder = new File("Data");

    public DatasController(){
        setActualGame();
    }

    /*Return a gamecontroller defined by the data */
    public GameController setActualGame(){

        //Test the opening/reading of the files
        try {
            File file = new File(dataFolder, "Curentgame.json");

            if (!file.exists()) {
                System.out.println("Curentgame.json introuvable dans le classpath !");
                return new GameController(null, 0, null);
            }

            String content = java.nio.file.Files.readString(file.toPath());
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
            File file = new File(dataFolder, "Records.json");

            if (!file.exists()) {
                System.out.println("Open of the data for the records is not possible");
                return new JSONArray();
            }

            String content = new String(java.nio.file.Files.readString(file.toPath()));
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

    /*Save the game if the record is better into the file records.json*/
    public void setRecords(String name, int level) {
        try {

            //Test of the opening
            File file = new File(dataFolder, "Records.json");
            if (!file.exists()) {
                System.out.println("Open of the data for the records is not possible");
                return;
            }

            //Read the files
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            JSONObject json = new JSONObject(content);

            //Definition of the old records
            JSONObject r1 = json.getJSONObject("record1");
            JSONObject r2 = json.getJSONObject("record2");
            JSONObject r3 = json.getJSONObject("record3");

            JSONObject newRecord = new JSONObject();
            newRecord.put("name", name);
            newRecord.put("level", level);

            //Test in order to see if the records is better
            if (level > r1.getInt("level")) {
                json.put("record3", r2);
                json.put("record2", r1);
                json.put("record1", newRecord);
            } else if (level > r2.getInt("level")) {
                json.put("record3", r2);
                json.put("record2", newRecord);
            } else if (level > r3.getInt("level")) {
                json.put("record3", newRecord);
            }

            //Write
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json.toString(4));
            }

        } catch (Exception e) {
            System.out.println("Save not possible");
        }
    }

    //Reset the content of the files Currentgame.json
    public void reset_game() {
        try {

            File file = new File(dataFolder, "Curentgame.json");
            if (!file.exists()) {
                System.out.println("Open of the data for the actual game is not possible for the reset");
                return;
            }
            
            //Save a empty game
            JSONObject game = new JSONObject();
            game.put("name", "");
            game.put("level", 0);

            JSONObject monster = new JSONObject();
            monster.put("hp", 0);
            monster.put("atq", 0);
            monster.put("def", 0);
            monster.put("spd", 0);
            monster.put("type", "");
            monster.put("talent", "");

            JSONArray monsterArray = new JSONArray();
            monsterArray.put(monster);

            game.put("monsters", monsterArray);

            JSONArray cardsArray = new JSONArray();
            for (int i = 0; i < 6; i++) {
                JSONObject card = new JSONObject();
                card.put("nameCard", "");
                card.put("rarity", 0);
                cardsArray.put(card);
            }
            game.put("cards", cardsArray);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(game.toString(4));
            }

        } catch (Exception e) {
            System.out.println("Save not possible");

        }
    }
}