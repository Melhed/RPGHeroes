package se.melhed.heroes;

import se.melhed.items.Item;
import se.melhed.items.Slot;

import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute levelAttributes;
    private HashMap<Slot, Item> equipment = new HashMap<>();

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }

    public void levelUp() {
        level++;
    }
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }
    public HeroAttribute getHeroAttribute() {
        return this.levelAttributes;
    }
    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }
}
