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
    void testGetHeroAttributes_twoStrSixDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(2, 6, 1);

        // Act
        HeroAttribute actual = rogue.getHeroAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testTotalAttributes_twoStrSixDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(2, 6, 1);

        // Act
        HeroAttribute actual = rogue.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        double expected = 1.06;

        // Act
        double actual = rogue.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDisplay_correctDisplay_shouldPass() {
        // Arrange
        String expected = "Name: Melvin | Class: Rogue | Level: 1\nStr: 2 | Dex: 6 | Int: 1\nDmg: 1.06";

        // Act
        String actual = rogue.display();

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
        void testGetHeroAttributes_threeStrTenDexTwoInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(3, 10, 2);

            // Act
            HeroAttribute actual = rogue.getHeroAttributes();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class OneArmorEquippedTest {
        Armor armor = new Armor("Armor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(8, 4, 9));

        @Test
        void testTotalAttributes_tenStrTenDexTenInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(10, 10, 10);

            // Act
            try {
                rogue.equipArmor(armor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = rogue.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class TwoArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(8, 4, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_20Str20Dex20Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(20, 20, 20);

            // Act
            try {
                rogue.equipArmor(legArmor);
                rogue.equipArmor(bodyArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = rogue.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(8, 4, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_30Str30Dex30Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(30, 30, 30);

            // Act
            try {
                rogue.equipArmor(legArmor);
                rogue.equipArmor(bodyArmor);
                rogue.equipArmor(headArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = rogue.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorOneReplacedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(8, 4, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor upgradedHeadArmor = new Armor("upgradedHeadArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(15, 15, 15));

        @Test
        void testTotalAttributes_35Str35Dex35Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(35, 35, 35);

            // Act
            try {
                rogue.equipArmor(legArmor);
                rogue.equipArmor(bodyArmor);
                rogue.equipArmor(headArmor);
                rogue.equipArmor(upgradedHeadArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = rogue.totalAttributes();

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
            double expected = 1060;

            // Act
            double actual = rogue.damage();

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
            double expected = 106;

            // Act
            double actual = rogue.damage();

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

            double expected = 2260;

            // Act
            double actual = rogue.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}