package se.melhed.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

public class WeaponTest {
    @Nested
    class weaponCreationTest {
        private Weapon weapon;

        @BeforeEach
        void setup() {
            weapon = new Weapon("Shusui", 10, WeaponType.SWORD, 100);
        }

        @Test
        void testGetName_nameShusui_shouldPass() {
            // Arrange
            String expected = "Shusui";

            // Act
            String actual = weapon.getName();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetRequiredLevel_levelTen_shouldPass() {
            // Arrange
            int expected = 10;

            // Act
            int actual = weapon.getRequiredLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetWeaponType_weaponTypeSword_shouldPass() {
            // Arrange
            WeaponType expected = WeaponType.SWORD;

            // Act
            WeaponType actual = weapon.getWeaponType();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetWeaponDamage_weaponDamage100_shouldPass() {
            // Arrange
            int expected = 100;

            // Act
            int actual = weapon.getWeaponDamage();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetSlot_slotWeapon_shouldPass() {
            // Arrange
            Slot expected = Slot.WEAPON;

            // Act
            Slot actual = weapon.getSlot();

            // Arrange
            assertEquals(expected, actual);
        }
    }
}
