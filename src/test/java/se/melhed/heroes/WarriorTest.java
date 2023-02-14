package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior;

    @BeforeEach
    void setup() {
        warrior = new Warrior("Melvin");
    }

    @Test
    void testGetName_nameMelvin_shouldPass() {
        // Arrange
        String expected = "Melvin";

        // Act
        String actual = warrior.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetLevel_levelOne_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = warrior.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetStrength_fiveStrength_shouldPass() {
        // Arrange
        int expected = 5;

        // Act
        int actual = warrior.getHeroAttributes().getStrength();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetDexterity_twoDexterity_shouldPass() {
        // Arrange
        int expected = 2;

        // Act
        int actual = warrior.getHeroAttributes().getDexterity();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIntelligence_oneIntelligence_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = warrior.getHeroAttributes().getIntelligence();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = warrior.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpWarrior() {
            warrior.levelUp();
        }

        @Test
        void testGetLevel_levelTwo_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = warrior.getLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_eightStrength_shouldPass() {
            // Arrange
            int expected = 8;

            // Act
            int actual = warrior.getHeroAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }
        @Test
        void testGetDexterity_fourDexterity_shouldPass() {
            // Arrange
            int expected = 4;

            // Act
            int actual = warrior.getHeroAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_twoIntelligence_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = warrior.getHeroAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }

    }
}