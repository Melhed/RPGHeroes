package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;

import java.text.DecimalFormat;
import java.util.Collections;

public class Mage extends Hero{

    public Mage(String name) {
        super(name);
        heroAttributes.increaseAttribute(new HeroAttribute(1, 1, 8));
        Collections.addAll(validArmorTypes, ArmorType.CLOTH);
        Collections.addAll(validWeaponTypes, WeaponType.STAFF, WeaponType.WAND);
    }

    @Override
    public double damage() {
        double damageMultiplier = 1 + ((double)totalAttributes().getIntelligence() / 100);

        if(getEquipment().get(Slot.WEAPON) instanceof Weapon weapon) {
            return weapon.getWeaponDamage()*damageMultiplier;
        }

        return 1 * damageMultiplier;
    }

    @Override
    public void levelUp() {
        heroAttributes.increaseAttribute(new HeroAttribute(1, 1, 5));
        level++;
    }

}
