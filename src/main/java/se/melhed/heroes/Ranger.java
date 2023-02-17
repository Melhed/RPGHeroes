package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.Collections;

public class Ranger extends Hero{

    public Ranger(String name) {
        super(name);
        heroAttributes.increaseAttribute(new HeroAttribute(1, 7, 1));
        Collections.addAll(validWeaponTypes, WeaponType.BOW);
        Collections.addAll(validArmorTypes, ArmorType.LEATHER, ArmorType.MAIL);
    }

    @Override
    public double damage() {
        double damageMultiplier = 1 + ((double)totalAttributes().getDexterity() / 100);

        if(getEquipment().get(Slot.WEAPON) instanceof Weapon weapon) {
            return weapon.getWeaponDamage()*damageMultiplier;
        }

        return 1 * damageMultiplier;
    }

    @Override
    public void levelUp() {
        level++;
        heroAttributes.increaseAttribute(new HeroAttribute(1, 5, 1));
    }
}
