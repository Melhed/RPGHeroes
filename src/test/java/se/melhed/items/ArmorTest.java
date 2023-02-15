package se.melhed.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.melhed.heroes.HeroAttribute;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;

public class ArmorTest {
        private Armor armor;

        @BeforeEach
        void setup() {
            armor = new Armor("Mecha", 10, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 2, 3));
        }

        @Test
        void testGetName_nameMecha_shouldPass() {
            // Arrange
            String expected = "Mecha";

            // Act
            String actual = armor.getName();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetRequiredLevel_levelTen_shouldPass(){
            // Arrange
            int expected = 10;

            // Act
            int actual = armor.getRequiredLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetSlot_slotBody_shouldPass() {
            // Arrange
            Slot expected = Slot.BODY;

            // Act
            Slot actual = armor.getSlot();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetArmorType_armorTypePlate_shouldPass() {
            // Arrange
            ArmorType expected = ArmorType.PLATE;

            // Act
            ArmorType actual = armor.getArmorType();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_oneStrength_shouldPass() {
            // Arrange
            int expected = 1;

            // Act
            int actual = armor.getArmorAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetDexterity_twoDexterity_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = armor.getArmorAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_threeIntelligence_shouldPass() {
            // Arrange
            int expected = 3;

            // Act
            int actual = armor.getArmorAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }

}