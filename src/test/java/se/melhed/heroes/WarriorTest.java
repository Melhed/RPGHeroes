package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.melhed.InvalidArmorException;
import se.melhed.InvalidWeaponException;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

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
    class LevelUpTest {
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

    @Nested
    class EquipWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.HAMMER, 1000);

        @Test
        void testDamage_1050Damage_shouldPass() {
            // Arrange
            try{
                warrior.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 1050;

            // Act
            int actual = warrior.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class ReplaceWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.HAMMER, 1000);
        Weapon replaceWeapon = new Weapon("replaceWeapon", 1, WeaponType.AXE, 100);

        @Test
        void testDamage_105Damage_shouldPass() {
            // Arrange
            try{
                warrior.equipWeapon(weapon);
                warrior.equipWeapon(replaceWeapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 105;

            // Act
            int actual = warrior.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FullArmorWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.HAMMER, 1000);
        Armor headArmor =  new Armor("headArmor", 1, Slot.HEAD, ArmorType.PLATE, new HeroAttribute(1000, 1, 1));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.PLATE, new HeroAttribute(1, 1, 1));

        @Test
        void testDamage_11070Damage_shouldPass() {
            // Arrange
            try{
                warrior.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }

            try{
                warrior.equipArmor(headArmor);
                warrior.equipArmor(bodyArmor);
                warrior.equipArmor(legArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            int expected = 11070;

            // Act
            int actual = warrior.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}