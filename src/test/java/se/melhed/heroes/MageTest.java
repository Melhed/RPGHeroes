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

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testGetHeroAttributes_oneStrOneDexEightInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(1, 1, 8);

        // Act
        HeroAttribute actual = mage.getHeroAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testTotalAttributes_oneStrOneDexEightInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(1, 1, 8);

        // Act
        HeroAttribute actual = mage.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        double expected = 1.08;

        // Act
        double actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDisplay_correctDisplay_shouldPass() {
        // Arrange
        String expected = "Name: Melvin | Class: Mage | Level: 1\nStr: 1 | Dex: 1 | Int: 8\nDmg: 1.08";

        // Act
        String actual = mage.display();

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
        void testGetHeroAttributes_twoStrTwoDexThirteenInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(2, 2, 13);

            // Act
            HeroAttribute actual = mage.getHeroAttributes();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class OneArmorEquippedTest {
        Armor armor = new Armor("Armor", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(9, 9, 2));

        @Test
        void testTotalAttributes_tenStrTenDexTenInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(10, 10, 10);

            // Act
            try {
               mage.equipArmor(armor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = mage.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class TwoArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(9, 9, 2));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_20Str20Dex20Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(20, 20, 20);

            // Act
            try {
                mage.equipArmor(legArmor);
                mage.equipArmor(bodyArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = mage.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(9, 9, 2));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_30Str30Dex30Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(30, 30, 30);

            // Act
            try {
                mage.equipArmor(legArmor);
                mage.equipArmor(bodyArmor);
                mage.equipArmor(headArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = mage.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorOneReplacedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(9, 9, 2));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));
        Armor upgradedHeadArmor = new Armor("upgradedHeadArmor", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(15, 15, 15));

        @Test
        void testTotalAttributes_35Str35Dex35Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(35, 35, 35);

            // Act
            try {
                mage.equipArmor(legArmor);
                mage.equipArmor(bodyArmor);
                mage.equipArmor(headArmor);
                mage.equipArmor(upgradedHeadArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = mage.totalAttributes();

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
            double expected = 1080;

            // Act
            double actual = mage.damage();

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
            double expected = 108;

            // Act
            double actual = mage.damage();

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

            double expected = 1380;

            // Act
            double actual = mage.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}