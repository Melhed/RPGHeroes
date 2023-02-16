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
    void testGetHeroAttributes_fiveStrTwoDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(5, 2, 1);

        // Act
        HeroAttribute actual = warrior.getHeroAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testTotalAttributes_fiveStrTwoDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(5, 2, 1);

        // Act
        HeroAttribute actual = warrior.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        double expected = 1.05;

        // Act
        double actual = warrior.damage();

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
        void testGetHeroAttributes_eightStrFourDexTwoInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(8, 4, 2);

            // Act
            HeroAttribute actual = warrior.getHeroAttributes();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class OneArmorEquippedTest {
        Armor armor = new Armor("Armor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(5, 8, 9));

        @Test
        void testTotalAttributes_tenStrTenDexTenInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(10, 10, 10);

            // Act
            try {
                warrior.equipArmor(armor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = warrior.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class TwoArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(5, 8, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_20Str20Dex20Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(20, 20, 20);

            // Act
            try {
                warrior.equipArmor(legArmor);
                warrior.equipArmor(bodyArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = warrior.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(5, 8, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_30Str30Dex30Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(30, 30, 30);

            // Act
            try {
                warrior.equipArmor(legArmor);
                warrior.equipArmor(bodyArmor);
                warrior.equipArmor(headArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = warrior.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorOneReplacedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(5, 8, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor upgradedHeadArmor = new Armor("upgradedHeadArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(15, 15, 15));

        @Test
        void testTotalAttributes_35Str35Dex35Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(35, 35, 35);

            // Act
            try {
                warrior.equipArmor(legArmor);
                warrior.equipArmor(bodyArmor);
                warrior.equipArmor(headArmor);
                warrior.equipArmor(upgradedHeadArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = warrior.totalAttributes();

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
            double expected = 1050;

            // Act
            double actual = warrior.damage();

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
            double expected = 105;

            // Act
            double actual = warrior.damage();

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

            double expected = 11070;

            // Act
            double actual = warrior.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}