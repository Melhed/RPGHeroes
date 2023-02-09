package se.melhed.items.weapon;

import se.melhed.items.Item;
import se.melhed.items.Slot;

public class Weapon extends Item {
    private String name;
    private int requiredLevel;
    private WeaponType weaponType;
    private int weaponDamage;
    private Slot slot;

    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
        this.slot = Slot.WEAPON;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public String getInfo() {
        return "Weapon " + getName() + " | Stats\nreqLvl: " + getRequiredLevel() + " | Slot: " + getSlot() + " | Type: " + getWeaponType() + " | Dmg: " + getWeaponDamage();
    }

    public String toString() {
        return getName();
    }

}
