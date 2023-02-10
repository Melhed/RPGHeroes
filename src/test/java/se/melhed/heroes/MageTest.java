package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private final Mage mage = new Mage("Melvin");

    @Test
    void mageShouldBeNamedMelvin() {
        assertEquals("Melvin", mage.getName());
    }

    @Test
    void mageShouldBeLevel1() {
        assertEquals(1, mage.getLevel());
    }

    @Test
    void mageShouldHave1Strength() {
        assertEquals(1, mage.getHeroAttributes().getStrength());
    }

    @Test
    void mageShouldHave1Dexterity() {
        assertEquals(1, mage.getHeroAttributes().getDexterity());
    }

    @Test
    void mageShouldHave8Intelligence() {
        assertEquals(8, mage.getHeroAttributes().getIntelligence());
    }

    @Test
    void mageShouldDo1Damage() {
        assertEquals(1, mage.damage());
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpMage() {
            mage.levelUp();
        }

        @Test
        void mageShouldBeLevel2() {
            assertEquals(2, mage.getLevel());
        }

        @Test
        void mageShouldHave2Strength() {
            assertEquals(2, mage.getHeroAttributes().getStrength());
        }
        @Test
        void mageShouldHave2Dexterity() {
            assertEquals(2, mage.getHeroAttributes().getDexterity());
        }

        @Test
        void mageShouldHave13Intelligence() {
            assertEquals(13, mage.getHeroAttributes().getIntelligence());
        }

    }

}