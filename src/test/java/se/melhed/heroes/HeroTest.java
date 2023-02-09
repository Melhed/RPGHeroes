package se.melhed.heroes;

import se.melhed.InvalidArmorException;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @org.junit.jupiter.api.Test
    void equipWrongArmorTypeShouldThrowException() {
        Mage mage = new Mage("Merlin");
        Armor bringa = new Armor("Bringa", 0, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1, 1, 1));
        Armor superBringa = new Armor("Bringa", 0, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(10, 10, 10));
        Armor superBringa2 = new Armor("Bringa", 0, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(0, 4, 2));
        Armor superBrallor = new Armor("Brallor", 0, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(1, 1 ,1));

        System.out.println(mage.getArmorAttributes());
        mage.equip(bringa);
        System.out.println(mage.getArmorAttributes());
        mage.equip(superBringa);
        System.out.println(mage.getArmorAttributes());

        mage.equip(superBringa2);
        System.out.println(mage.getArmorAttributes());
        mage.equip(superBrallor);
        System.out.println(mage.getArmorAttributes());
        System.out.println(mage.getTotalAttributes());
    }

}