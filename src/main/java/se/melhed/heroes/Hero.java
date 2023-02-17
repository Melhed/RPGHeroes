package se.melhed.heroes;

import se.melhed.InvalidArmorException;
import se.melhed.InvalidWeaponException;
import se.melhed.items.Item;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

import java.util.*;

public abstract class Hero {

    protected final String name;
    protected int level = 1;
    protected final HeroAttribute heroAttributes = new HeroAttribute(0, 0, 0);
    protected final HashMap<Slot, Item> equipment = new HashMap<>();
    protected final Set<WeaponType> validWeaponTypes = new HashSet<>();
    protected final Set<ArmorType> validArmorTypes = new HashSet<>();

    public Hero(String name) {
        this.name = name;
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }

    // Calculates hero's attributes together
    public HeroAttribute totalAttributes() {
        HeroAttribute heroAttr = getHeroAttributes();
        HeroAttribute armorAttr = getArmorAttributes();

        return new HeroAttribute(
                heroAttr.getStrength() + armorAttr.getStrength(),
                heroAttr.getDexterity() + armorAttr.getDexterity(),
                heroAttr.getIntelligence() + armorAttr.getIntelligence()
        );
    }

    // Calculates sum of all equipped armor pieces' attributes
    public HeroAttribute getArmorAttributes() {
        HeroAttribute armorAttribute = new HeroAttribute(0, 0, 0);

        for(Map.Entry<Slot, Item> entry : getEquipment().entrySet()) {
            if(entry.getValue() != null && entry.getValue() instanceof Armor armor) {
                armorAttribute.increaseAttribute(armor.getArmorAttributes());
            }
        }

        return armorAttribute;
    }

    // Equips a weapon assuming correct WeaponType and level requirements
    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if(!getValidWeaponTypes().contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException(getName() + " can't wield WeaponType "+ weapon.getWeaponType() + ".");
        }
        if(weapon.getRequiredLevel() > this.level) {
            throw new InvalidWeaponException(getName() + " requires a higher level to wield " + weapon.getName() + ".");
        }
        this.equipment.put(weapon.getSlot(), weapon);
    }

    // Equips an armor piece assuming correct ArmorType and level requirements
    public void equipArmor(Armor armor) throws InvalidArmorException {
        if(!getValidArmorTypes().contains((armor).getArmorType())) {
            throw new InvalidArmorException(getName() + " can't wear ArmorType " + armor.getArmorType() + ".");
        }
        if(armor.getRequiredLevel() > this.level) {
            throw new InvalidArmorException(getName() + " requires a higher level to wear " + armor.getName() + ".");
        }

        getArmorAttributes().increaseAttribute(armor.getArmorAttributes());
        this.equipment.put(armor.getSlot(), armor);
    }

    // Returns a String showcasing the hero's basic attributes
    public String display() {

        return "Name: " + this.getName() + " | " +
                "Class: " + this.getClass().getSimpleName() + " | " +
                "Level: " + this.getLevel() + "\n" +
                "Str: " + this.totalAttributes().getStrength() + " | " +
                "Dex: " + this.totalAttributes().getDexterity() + " | " +
                "Int: " + this.totalAttributes().getIntelligence() + "\n" +
                "Dmg: " + this.damage();
    }

    public abstract double damage();
    public abstract void levelUp();
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }
    public HeroAttribute getHeroAttributes() {
        return this.heroAttributes;
    }
    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }
    public Set<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }
    public Set<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

}
