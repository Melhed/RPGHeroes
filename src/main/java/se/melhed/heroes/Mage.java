package se.melhed.heroes;

import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.WeaponType;

import java.util.ArrayList;
import java.util.Collections;

public class Mage extends Hero{
    private String name;
    private int level;
    private HeroAttribute heroAttributes = new HeroAttribute(1, 1, 8);
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Mage(String name) {
        super(name);
        Collections.addAll(validWeaponTypes = new ArrayList<WeaponType>(), WeaponType.STAFF, WeaponType.WAND);
        Collections.addAll(validArmorTypes = new ArrayList<ArmorType>(), ArmorType.CLOTH);
    }

    public void levelUp() {
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 1, 5));
        this.level++;
    }
}
