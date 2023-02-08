package se.melhed.heroes;

import se.melhed.items.Item;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute heroAttributes;
    private HeroAttribute armorAttribute;
    private HashMap<Slot, Item> equipment = new HashMap<>();
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);

    }

    public void levelUp() {
        level++;
    }
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }
    public HeroAttribute getHeroAttribute() {
        return this.heroAttributes;
    }
    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }
    public HeroAttribute getTotalAttributes() {
        return new HeroAttribute(
                this.heroAttributes.getStrength() + this.armorAttribute.getStrength(),
                this.heroAttributes.getDexterity() + this.armorAttribute.getDexterity(),
                this.heroAttributes.getIntelligence() + this.armorAttribute.getIntelligence()
        );
    }

    public boolean canEquip(Item item) {
        if(item instanceof Weapon && !this.validWeaponTypes.contains(((Weapon) item).getWeaponType())) return false;
        if(item instanceof Armor && !this.validArmorTypes.contains(((Armor) item).getArmorType())) return false;
        if(item.getRequiredLevel() > this.level) return false;
        return true;
    }

    public void equipItem(Item item) {
        if(!canEquip(item)) {
            // Handle exceptions
            return;
        }

        this.equipment.put(item.getSlot(), item);
    }
}
