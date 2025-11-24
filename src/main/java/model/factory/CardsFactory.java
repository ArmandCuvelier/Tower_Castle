package model.factory;

import model.cards.Cards;
import model.cards.Hares;
import model.cards.Hygie;

public class CardsFactory {
    public Cards getCards(String name, int rarity){
        switch (name) {
            case "hares":
                return new Hares(rarity, false);
        
            case "hygie":
                return new Hygie(rarity, false);
            
            default :
                return new Hygie(rarity,false);
        }
    }
}
