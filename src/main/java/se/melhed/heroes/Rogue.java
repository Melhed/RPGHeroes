package se.melhed.heroes;

import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.WeaponType;

import java.util.ArrayList;
import java.util.Collections;

public class Rogue extends Hero{
    private String name;
    private int level;
    private HeroAttribute heroAttributes = new HeroAttribute(2, 6, 1);
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Rogue(String name) {
        super(name);
        Collections.addAll(validWeaponTypes = new ArrayList<WeaponType>(), WeaponType.DAGGER, WeaponType.SWORD);
        Collections.addAll(validArmorTypes = new ArrayList<ArmorType>(), ArmorType.LEATHER, ArmorType.MAIL);
    }

    public void levelUp() {
        this.level++;
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 4, 1));
    }
}
