package se.melhed.heroes;

import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.WeaponType;

import java.util.ArrayList;
import java.util.Collections;

public class Warrior extends Hero{
    private String name;
    private int level;
    private HeroAttribute heroAttributes = new HeroAttribute(5, 2, 1);
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;
    public Warrior(String name) {
        super(name);
        Collections.addAll(validWeaponTypes = new ArrayList<WeaponType>(), WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD);
        Collections.addAll(validArmorTypes = new ArrayList<ArmorType>(), ArmorType.MAIL, ArmorType.PLATE);

    }

    public void levelUp() {
        this.level++;
        this.heroAttributes.increaseAttribute(new HeroAttribute(3,2, 1));
    }

}
