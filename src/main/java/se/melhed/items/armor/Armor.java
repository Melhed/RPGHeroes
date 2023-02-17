package se.melhed.items.armor;

import se.melhed.heroes.HeroAttribute;
import se.melhed.items.Item;
import se.melhed.items.Slot;

public class Armor extends Item {
    private final ArmorType armorType;
    private final HeroAttribute armorAttributes;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttributes) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttributes = armorAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttribute getArmorAttributes() {
        return armorAttributes;
    }
}
