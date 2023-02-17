package se.melhed.items.weapon;

import se.melhed.items.Item;
import se.melhed.items.Slot;

public class Weapon extends Item {
    private final WeaponType weaponType;
    private final int weaponDamage;

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

}
