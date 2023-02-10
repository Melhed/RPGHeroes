package se.melhed.heroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private final Warrior warrior = new Warrior("Melvin");

    @Test
    void warriorShouldBeNamedMelvin() {
        assertEquals("Melvin", warrior.getName());
    }

    @Test
    void warriorShouldBeLevel1() {
        assertEquals(1, warrior.getLevel());
    }

    @Test
    void warriorShouldHave1Strength() {
        assertEquals(5, warrior.getHeroAttributes().getStrength());
    }

    @Test
    void warriorShouldHave6Dexterity() {
        assertEquals(2, warrior.getHeroAttributes().getDexterity());
    }

    @Test
    void warriorShouldHave1Intelligence() {
        assertEquals(1, warrior.getHeroAttributes().getIntelligence());
    }

    @Test
    void warriorShouldDo1Damage() {
        assertEquals(1, warrior.damage());
    }

    @Nested
    class levelIncreaseTest {
        @BeforeEach
        void levelUpWarrior() {
            warrior.levelUp();
        }

        @Test
        void warriorShouldBeLevel2() {
            assertEquals(2, warrior.getLevel());
        }

        @Test
        void warriorShouldHave3Strength() {
            assertEquals(8, warrior.getHeroAttributes().getStrength());
        }
        @Test
        void warriorShouldHave10Dexterity() {
            assertEquals(4, warrior.getHeroAttributes().getDexterity());
        }

        @Test
        void warriorShouldHave2Intelligence() {
            assertEquals(2, warrior.getHeroAttributes().getIntelligence());
        }

    }

    @Nested
    class equipmentTest {
        private final Armor bodyArmor = new Armor("bodyArmor", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));

    }

}