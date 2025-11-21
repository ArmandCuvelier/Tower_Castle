import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.cards.Hygie;
import model.monsters.Air_Monsters;
import model.monsters.Monsters;

public class HygieTest {
    static Monsters monsters;

    @BeforeEach
    public void setUp() {
        monsters = new Air_Monsters(10, 0);
    }

    @Test
    public void TestRarity(){
        for (int i = 0; i < 10; i++) {
            cards = new Hygie(1);
            print(cards.getRarity());
        }
        for (int i = 0; i < 10; i++) {
            cards = new Hygie(15);
            print(cards.getRarity());
        }
        for (int i = 0; i < 10; i++) {
            cards = new Hygie(20);
            print(cards.getRarity());
        }
    }
}
