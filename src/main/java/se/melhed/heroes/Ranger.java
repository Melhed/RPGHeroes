package se.melhed.heroes;

import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.WeaponType;

import java.util.ArrayList;
import java.util.Collections;

public class Ranger extends Hero{
    private String name;
    private int level;
    private HeroAttribute heroAttributes;
    private HeroAttribute armorAttributes;
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Ranger(String name) {
        super(name);
        this.heroAttributes = getHeroAttribute();
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 7, 1));
        this.armorAttributes = getArmorAttributes();
        this.validArmorTypes = getValidArmorTypes();
        this.validWeaponTypes = getValidWeaponTypes();
        Collections.addAll(validWeaponTypes, WeaponType.BOW);
        Collections.addAll(validArmorTypes, ArmorType.LEATHER, ArmorType.MAIL);
    }

    public void damage() {

    }

    public void levelUp() {
        this.level++;
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 5, 1));
    }
}
