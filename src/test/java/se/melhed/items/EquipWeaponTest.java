package se.melhed.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.melhed.InvalidWeaponException;
import se.melhed.heroes.Mage;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EquipWeaponTest {
    private Mage mage;
    @Nested
    class EquipWeaponTypeExceptionTest {
        Weapon weapon;

        @BeforeEach
        void setup() {
            mage = new Mage("Mage");
            weapon = new Weapon("Exception Weapon", 1, WeaponType.AXE, 10);
        }

        @Test
        void testEquipWeapon_invalidWeaponExceptionCantWieldWeaponTypeMessage_shouldPass() {
            // Arrange
            String expected = "Mage can't wield WeaponType AXE.";

            // Act
            Exception weaponException = assertThrows(InvalidWeaponException.class, () -> mage.equipWeapon(weapon));
            String actual = weaponException.getMessage();

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class EquipWeaponLevelExceptionTest {
        Weapon weapon;

        @BeforeEach
        void setup() {
            mage = new Mage("Mage");
            weapon = new Weapon("Exception Weapon", 5, WeaponType.WAND, 10);
        }

        @Test
        void testEquipWeapon_invalidWeaponExceptionHigherLevelRequiredMessage_shouldPass() {
            // Arrange
            String expected = "Mage requires a higher level to wield Exception Weapon.";

            // Act
            Exception weaponException = assertThrows(InvalidWeaponException.class, () -> mage.equipWeapon(weapon));
            String actual = weaponException.getMessage();

            // Assert
            assertEquals(expected, actual);
        }

    }
}
