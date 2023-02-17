package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.Collections;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        getHeroAttributes().increaseAttribute(new HeroAttribute(2, 6, 1));
        Collections.addAll(validWeaponTypes, WeaponType.DAGGER, WeaponType.SWORD);
        Collections.addAll(validArmorTypes, ArmorType.LEATHER, ArmorType.MAIL);
    }

    // Calculates the damage output of the Rogue via it's potentially equipped weapon and armor.
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
        this.level++;
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 4, 1));
    }
}
