package se.melhed.heroes;

import se.melhed.InvalidArmorException;
import se.melhed.InvalidWeaponException;
import se.melhed.items.Item;
import se.melhed.items.Slot;
import se.melhed.items.armor.Armor;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Hero {

    protected final String name;
    protected int level;
    protected final HeroAttribute heroAttributes;
    protected final HashMap<Slot, Item> equipment = new HashMap<>();
    protected final ArrayList<WeaponType> validWeaponTypes;
    protected final ArrayList<ArmorType> validArmorTypes;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.heroAttributes = new HeroAttribute(0, 0, 0);
        this.validWeaponTypes = new ArrayList<>();
        this.validArmorTypes = new ArrayList<>();
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }

    public HeroAttribute getTotalAttributes() {
        HeroAttribute heroAttr = getHeroAttributes();
        HeroAttribute armorAttr = getArmorAttributes();
        return new HeroAttribute(
                heroAttr.getStrength() + armorAttr.getStrength(),
                heroAttr.getDexterity() + armorAttr.getDexterity(),
                heroAttr.getIntelligence() + armorAttr.getIntelligence()
        );
    }

    public HeroAttribute getArmorAttributes() {
        HeroAttribute armorAttribute = new HeroAttribute(0, 0, 0);

        for(Map.Entry<Slot, Item> entry : getEquipment().entrySet()) {
            if(entry.getValue() != null && entry.getValue() instanceof Armor) {
                armorAttribute.increaseAttribute(((Armor) entry.getValue()).getArmorAttributes());
            }
        }
        return armorAttribute;
    }

    private void canEquipWeapon(Weapon weapon) throws InvalidWeaponException {
            if(!getValidWeaponTypes().contains(weapon.getWeaponType())) throw new InvalidWeaponException(getName() + " can't wield weapons of type "+ weapon.getWeaponType() +".");
            if(weapon.getRequiredLevel() > this.level) throw new InvalidWeaponException(getName() + " requires a higher level to wield " + weapon.getName() + ".");
    }
    private void canEquipArmor(Armor armor) throws InvalidArmorException {
        if(!getValidArmorTypes().contains((armor).getArmorType())) throw new InvalidArmorException(getName() + " can't wear armor of type " + armor.getArmorType() + ".");
        if(armor.getRequiredLevel() > this.level) throw new InvalidArmorException(getName() + " requires a higher level to wear " + armor.getName() + ".");
    }

    public void equip(Item item){
        if(item instanceof Weapon weapon) {
            try {
                canEquipWeapon(weapon);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        if(item instanceof Armor armor) {
            try{
                canEquipArmor(armor);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
                return;
            }
            getArmorAttributes().increaseAttribute(armor.getArmorAttributes());
        }

        this.equipment.put(item.getSlot(), item);
    }

    public abstract int damage();
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
    public ArrayList<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }
    public ArrayList<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

}
