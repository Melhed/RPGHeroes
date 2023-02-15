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

class RogueTest {
    Rogue rogue;

    @BeforeEach
    void setup() {
        rogue = new Rogue("Melvin");
    }

    @Test
    void testGetName_nameMelvin_shouldPass() {
        // Arrange
        String expected = "Melvin";

        // Act
        String actual = rogue.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetLevel_levelOne_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetStrength_twoStrength_shouldPass() {
        // Arrange
        int expected = 2;

        // Act
        int actual = rogue.getHeroAttributes().getStrength();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetDexterity_sixDexterity_shouldPass() {
        // Arrange
        int expected = 6;

        // Act
        int actual = rogue.getHeroAttributes().getDexterity();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIntelligence_oneIntelligence_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.getHeroAttributes().getIntelligence();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        int expected = 1;

        // Act
        int actual = rogue.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Nested
    class LevelUpTest {
        @BeforeEach
        void levelUpRogue() {
            rogue.levelUp();
        }

        @Test
        void testGetLevel_levelTwo_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = rogue.getLevel();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetStrength_threeStrength_shouldPass() {
            // Arrange
            int expected = 3;

            // Act
            int actual = rogue.getHeroAttributes().getStrength();

            // Assert
            assertEquals(expected, actual);
        }
        @Test
        void testGetDexterity_tenDexterity_shouldPass() {
            // Arrange
            int expected = 10;

            // Act
            int actual = rogue.getHeroAttributes().getDexterity();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void testGetIntelligence_twoIntelligence_shouldPass() {
            // Arrange
            int expected = 2;

            // Act
            int actual = rogue.getHeroAttributes().getIntelligence();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class EquipWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.DAGGER, 1000);

        @Test
        void testDamage_1060Damage_shouldPass() {
            // Arrange
            try{
                rogue.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 1060;

            // Act
            int actual = rogue.damage();

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class ReplaceWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.SWORD, 1000);
        Weapon replaceWeapon = new Weapon("replaceWeapon", 1, WeaponType.DAGGER, 100);

        @Test
        void testDamage_106Damage_shouldPass() {
            // Arrange
            try{
                rogue.equipWeapon(weapon);
                rogue.equipWeapon(replaceWeapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }
            int expected = 106;

            // Act
            int actual = rogue.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FullArmorWeaponDamageTest {
        Weapon weapon = new Weapon("Weapon", 1, WeaponType.DAGGER, 1000);
        Armor headArmor =  new Armor("headArmor", 1, Slot.HEAD, ArmorType.LEATHER, new HeroAttribute(1, 100, 1));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 10, 1));
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.LEATHER, new HeroAttribute(1, 10, 1));

        @Test
        void testDamage_2260Damage_shouldPass() {
            // Arrange
            try{
                rogue.equipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
            }

            try{
                rogue.equipArmor(headArmor);
                rogue.equipArmor(bodyArmor);
                rogue.equipArmor(legArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            int expected = 2260;

            // Act
            int actual = rogue.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}