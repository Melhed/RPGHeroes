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
    void testGetHeroAttributes_oneStrSevenDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(1, 7, 1);

        // Act
        HeroAttribute actual = ranger.getHeroAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testTotalAttributes_oneStrSevenDexOneInt_shouldPass() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(1, 7, 1);

        // Act
        HeroAttribute actual = ranger.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDamage_oneDamage_shouldPass() {
        // Arrange
        double expected = 1.07;

        // Act
        double actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDisplay_correctDisplay_shouldPass() {
        // Arrange
        String expected = "Name: Melvin | Class: Ranger | Level: 1\nStr: 1 | Dex: 7 | Int: 1\nDmg: 1.07";

        // Act
        String actual = ranger.display();

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
        void testGetHeroAttributes_oneStrSevenDexOneInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(2, 12, 2);

            // Act
            HeroAttribute actual = ranger.getHeroAttributes();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class OneArmorEquippedTest {
        Armor armor = new Armor("Armor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(9, 3, 9));

        @Test
        void testTotalAttributes_tenStrTenDexTenInt_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(10, 10, 10);

            // Act
            try {
                ranger.equipArmor(armor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = ranger.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class TwoArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(9, 3, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_20Str20Dex20Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(20, 20, 20);

            // Act
            try {
                ranger.equipArmor(legArmor);
                ranger.equipArmor(bodyArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = ranger.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorEquippedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(9, 3, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));

        @Test
        void testTotalAttributes_30Str30Dex30Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(30, 30, 30);

            // Act
            try {
                ranger.equipArmor(legArmor);
                ranger.equipArmor(bodyArmor);
                ranger.equipArmor(headArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = ranger.totalAttributes();

            // Assert
            assertEquals(expected, actual);

        }
    }

    @Nested
    class ThreeArmorOneReplacedTest {
        Armor legArmor = new Armor("legArmor", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(9, 3, 9));
        Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor headArmor = new Armor("headArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(10, 10, 10));
        Armor upgradedHeadArmor = new Armor("upgradedHeadArmor", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(15, 15, 15));

        @Test
        void testTotalAttributes_35Str35Dex35Int_shouldPass() {
            // Arrange
            HeroAttribute expected = new HeroAttribute(35, 35, 35);

            // Act
            try {
                ranger.equipArmor(legArmor);
                ranger.equipArmor(bodyArmor);
                ranger.equipArmor(headArmor);
                ranger.equipArmor(upgradedHeadArmor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
            }

            HeroAttribute actual = ranger.totalAttributes();

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
            double expected = 1070;

            // Act
            double actual = ranger.damage();

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
            double expected = 107;

            // Act
            double actual = ranger.damage();

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

            double expected = 2270;

            // Act
            double actual = ranger.damage();

            // Assert
            assertEquals(expected, actual);
        }
    }

}
