package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.Collections;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
        heroAttributes.increaseAttribute(new HeroAttribute(5, 2, 1));
        Collections.addAll(validArmorTypes, ArmorType.MAIL, ArmorType.PLATE);
        Collections.addAll(validWeaponTypes, WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD);
    }

    @Override
    public int damage() {
        double damageMultiplier = 1 + ((double)totalAttributes().getStrength() / 100);

        if(getEquipment().get(Slot.WEAPON) instanceof Weapon weapon) {
            return (int) (weapon.getWeaponDamage()*damageMultiplier);
        }

        return (int) (1 * damageMultiplier);
    }

    @Override
    public void levelUp() {
        level++;
        heroAttributes.increaseAttribute(new HeroAttribute(3,2, 1));
    }
}
