package se.melhed.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.melhed.InvalidArmorException;
import se.melhed.heroes.HeroAttribute;
import se.melhed.heroes.Mage;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EquipArmorTest {

    @Nested
    class EquipArmorLevelExceptionTest {
        Mage mage;
        Armor armor;

        @BeforeEach
        void setup() {
            mage = new Mage("Mage");
            armor = new Armor("Exception Armor", 5, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(1, 1, 1));
        }

        @Test
        void testEquipArmor_invalidArmorExceptionHigherLevelRequiredMessage_shouldPass() {
            // Arrange
            String expected = "Mage requires a higher level to wear Exception Armor.";

            // Act
            Exception armorException = assertThrows(InvalidArmorException.class, () -> mage.equipArmor(armor));

            String actual = armorException.getMessage();

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class EquipArmorTypeExceptionTest {
        Mage mage;
        Armor armor;

        @BeforeEach
        void setup() {
            mage = new Mage("Mage");
            armor = new Armor("Exception Armor", 1, Slot.LEGS, ArmorType.PLATE, new HeroAttribute(1, 1, 1));
        }

        @Test
        void testEquipArmor_invalidArmorExceptionCantWearArmorTypeMessage_shouldPass() {
            // Arrange
            String expected = "Mage can't wear ArmorType PLATE.";

            // Act
            Exception armorException = assertThrows(InvalidArmorException.class, () -> mage.equipArmor(armor));

            String actual = armorException.getMessage();

            // Assert
            assertEquals(expected, actual);
        }

    }
}
