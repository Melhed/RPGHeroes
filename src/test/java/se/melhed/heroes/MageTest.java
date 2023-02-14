package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Mage mage;

    @BeforeEach
    void setup() {
        mage = new Mage("Melvin");
    }

    @Test
    void testGetName_nameMelvin_shouldPass() {
        // Arrange
        String expected = "Melvin";

        // Act
        String actual = mage.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetLevel_levelOne_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = mage.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetStrength_oneStrength_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = mage.getHeroAttributes().getStrength();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetDexterity_oneDexterity_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = mage.getHeroAttributes().getDexterity();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIntelligence_eightIntelligence_shouldPass() {
        // Arrange
        int expected = 8;

        // Act
        int actual = mage.getHeroAttributes().getIntelligence();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpMage() {
            mage.levelUp();
        }

        @Test
        void testGetLevel_levelTwo_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = mage.getLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_twoStrength_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = mage.getHeroAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }
        @Test
        void testGetDexterity_twoDexterity_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = mage.getHeroAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_thirteenIntelligence_shouldPass() {
            // Arrange
            int expected = 13;

            // Act
            int actual = mage.getHeroAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }

    }
}