package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    Ranger ranger;

    @BeforeEach
    void setup() {
        ranger = new Ranger("Melvin");
    }

    @Test
    void testGetName_nameMelvin_shouldPass() {
        // Arrange
        String expected = "Melvin";

        // Act
        String actual = ranger.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetLevel_levelOne_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = ranger.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetStrength_oneStrength_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = ranger.getHeroAttributes().getStrength();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetDexterity_sevenDexterity_shouldPass() {
        // Arrange
        int expected = 7;

        // Act
        int actual = ranger.getHeroAttributes().getDexterity();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIntelligence_oneIntelligence_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = ranger.getHeroAttributes().getIntelligence();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpRanger() {
            ranger.levelUp();
        }

        @Test
        void testGetLevel_levelTwo_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = ranger.getLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_twoStrength_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = ranger.getHeroAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }
        @Test
        void testGetDexterity_twelveDexterity_shouldPass() {
            // Arrange
            int expected = 12;

            // Act
            int actual = ranger.getHeroAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_twoIntelligence_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = ranger.getHeroAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }

    }
}
