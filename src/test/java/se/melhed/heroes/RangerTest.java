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
    class LevelUpTest {
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

    @Nested
    class EquipWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.BOW, 1000);

        @Test
        void testDamage_1070Damage_shouldPass() {
            // Arrange
            try{
                ranger.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 1070;

            // Act
            int actual = ranger.damage();

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class ReplaceWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.BOW, 1000);
        Weapon replaceWeapon = new Weapon("replaceWeapon", 1, WeaponType.BOW, 100);

        @Test
        void testDamage_107Damage_shouldPass() {
            // Arrange
            try{
                ranger.equipWeapon(weapon);
                ranger.equipWeapon(replaceWeapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 107;

            // Act
            int actual = ranger.damage();

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class FullArmorWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.BOW, 1000);
        Armor headArmor =  new Armor("headArmor", 1, Slot.HEAD, ArmorType.LEATHER, new HeroAttribute(1, 100, 1));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 10, 1));
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.LEATHER, new HeroAttribute(1, 10, 1));

        @Test
        void testDamage_2270Damage_shouldPass() {
            // Arrange
            try{
                ranger.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }

            try{
                ranger.equipArmor(headArmor);
                ranger.equipArmor(bodyArmor);
                ranger.equipArmor(legArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            int expected = 2270;

            // Act
            int actual = ranger.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}
