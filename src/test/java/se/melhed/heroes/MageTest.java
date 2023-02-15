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
    class LevelIncreaseTest {
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

    @Nested
    class EquipWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.WAND, 1000);

        @Test
        void testDamage_1080Damage_shouldPass() {
            // Arrange
            try{
                mage.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 1080;

            // Act
            int actual = mage.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class ReplaceWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.WAND, 1000);
        Weapon replaceWeapon = new Weapon("replaceWeapon", 1, WeaponType.STAFF, 100);

        @Test
        void testDamage_108Damage_shouldPass() {
            // Arrange
            try{
                mage.equipWeapon(weapon);
                mage.equipWeapon(replaceWeapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 108;

            // Act
            int actual = mage.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FullArmorWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.WAND, 1000);
        Armor headArmor =  new Armor("headArmor", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1, 1, 10));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1, 1, 10));
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(1, 1, 10));

        @Test
        void testDamage_1380Damage_shouldPass() {
            // Arrange
            try{
                mage.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }

            try{
                mage.equipArmor(headArmor);
                mage.equipArmor(bodyArmor);
                mage.equipArmor(legArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            int expected = 1380;

            // Act
            int actual = mage.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }



}