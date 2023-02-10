package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    private final Ranger ranger = new Ranger("Melvin");

    @Test
    void rangerShouldBeNamedMelvin() {
        assertEquals("Melvin", ranger.getName());
    }

    @Test
    void rangerShouldBeLevel1() {
        assertEquals(1, ranger.getLevel());
    }

    @Test
    void rangerShouldHave1Strength() {
        assertEquals(1, ranger.getHeroAttributes().getStrength());
    }

    @Test
    void rangerShouldHave7Dexterity() {
        assertEquals(7, ranger.getHeroAttributes().getDexterity());
    }

    @Test
    void rangerShouldHave1Intelligence() {
        assertEquals(1, ranger.getHeroAttributes().getIntelligence());
    }

    @Test
    void rangerShouldDo1Damage() {
        assertEquals(1, ranger.damage());
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpRanger() {
            ranger.levelUp();
        }

        @Test
        void rangerShouldBeLevel2() {
            assertEquals(2, ranger.getLevel());
        }

        @Test
        void rangerShouldHave2Strength() {
            assertEquals(2, ranger.getHeroAttributes().getStrength());
        }
        @Test
        void rangerShouldHave12Dexterity() {
            assertEquals(12, ranger.getHeroAttributes().getDexterity());
        }

        @Test
        void rangerShouldHave2Intelligence() {
            assertEquals(2, ranger.getHeroAttributes().getIntelligence());
        }

    }

}
