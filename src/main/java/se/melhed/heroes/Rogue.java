package se.melhed.heroes;

import se.melhed.items.Slot;
import se.melhed.items.armor.ArmorType;
import se.melhed.items.weapon.Weapon;
import se.melhed.items.weapon.WeaponType;
import java.util.Collections;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        heroAttributes.increaseAttribute(new HeroAttribute(2, 6, 1));
        Collections.addAll(validWeaponTypes, WeaponType.DAGGER, WeaponType.SWORD);
        Collections.addAll(validArmorTypes, ArmorType.LEATHER, ArmorType.MAIL);
    }

    @Override
    public int damage() {
        if(getEquipment().get(Slot.WEAPON) instanceof Weapon weapon) {
            return weapon.getWeaponDamage() * (1+(getHeroAttributes().getDexterity()/100));
        }
        return 1*(1+(getHeroAttributes().getDexterity()/100));
    }

    @Override
    public void levelUp() {
        this.level++;
        this.heroAttributes.increaseAttribute(new HeroAttribute(1, 4, 1));
    }
}
