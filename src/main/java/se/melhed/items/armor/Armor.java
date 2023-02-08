package se.melhed.items.armor;

import se.melhed.heroes.HeroAttribute;
import se.melhed.items.Item;
import se.melhed.items.Slot;

public class Armor extends Item {
    private String name;
    private int requiredLevel;
    private Slot slot;
    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

}
