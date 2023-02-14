package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    Rogue rogue;

    @BeforeEach
    void setup() {
        rogue = new Rogue("Melvin");
    }

    @Test
    void testGetName_nameMelvin_shouldPass() {
        // Arrange
        String expected = "Melvin";

        // Act
        String actual = rogue.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetLevel_levelOne_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetStrength_twoStrength_shouldPass() {
        // Arrange
        int expected = 2;

        // Act
        int actual = rogue.getHeroAttributes().getStrength();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetDexterity_sixDexterity_shouldPass() {
        // Arrange
        int expected = 6;

        // Act
        int actual = rogue.getHeroAttributes().getDexterity();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIntelligence_oneIntelligence_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.getHeroAttributes().getIntelligence();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpRogue() {
            rogue.levelUp();
        }

        @Test
        void testGetLevel_levelTwo_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = rogue.getLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_threeStrength_shouldPass() {
            // Arrange
            int expected = 3;

            // Act
            int actual = rogue.getHeroAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }
        @Test
        void testGetDexterity_tenDexterity_shouldPass() {
            // Arrange
            int expected = 10;

            // Act
            int actual = rogue.getHeroAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_twoIntelligence_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = rogue.getHeroAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }

    }
}