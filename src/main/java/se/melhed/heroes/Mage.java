package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

import java.util.ArrayList;
import java.util.Collections;

public class Mage extends Hero{
    private String name;
    private int level;
    private HeroAttribute heroAttributes;
    private HeroAttribute armorAttributes;
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Mage(String name) {
        super(name);
        this.level = getLevel();
        this.heroAttributes = getHeroAttribute();
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 1, 8));
        this.armorAttributes = getArmorAttributes();
        this.validArmorTypes = getValidArmorTypes();
        this.validWeaponTypes = getValidWeaponTypes();
        Collections.addAll(validArmorTypes, ArmorType.CLOTH);
        Collections.addAll(validWeaponTypes, WeaponType.STAFF, WeaponType.WAND);
    }

    @Override
    public void damage() {

    }

    public void levelUp() {
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 1, 5));
        this.level++;
    }

}
