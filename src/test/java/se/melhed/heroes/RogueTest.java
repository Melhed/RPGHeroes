package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    private final Rogue rogue = new Rogue("Melvin");

    @Test
    void rogueShouldBeNamedMelvin() {
        assertEquals("Melvin", rogue.getName());
    }

    @Test
    void rogueShouldBeLevel1() {
        assertEquals(1, rogue.getLevel());
    }

    @Test
    void rogueShouldHave1Strength() {
        assertEquals(2, rogue.getHeroAttributes().getStrength());
    }

    @Test
    void rogueShouldHave6Dexterity() {
        assertEquals(6, rogue.getHeroAttributes().getDexterity());
    }

    @Test
    void rogueShouldHave1Intelligence() {
        assertEquals(1, rogue.getHeroAttributes().getIntelligence());
    }

    @Test
    void rogueShouldDo1Damage() {
        assertEquals(1, rogue.damage());
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpRogue() {
            rogue.levelUp();
        }

        @Test
        void rogueShouldBeLevel2() {
            assertEquals(2, rogue.getLevel());
        }

        @Test
        void rogueShouldHave3Strength() {
            assertEquals(3, rogue.getHeroAttributes().getStrength());
        }
        @Test
        void rogueShouldHave10Dexterity() {
            assertEquals(10, rogue.getHeroAttributes().getDexterity());
        }

        @Test
        void rogueShouldHave2Intelligence() {
            assertEquals(2, rogue.getHeroAttributes().getIntelligence());
        }

    }

}