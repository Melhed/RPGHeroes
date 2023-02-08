package se.melhed.heroes;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void increaseAttribute(HeroAttribute attribute) {
        this.strength += attribute.strength;
        this.dexterity += attribute.dexterity;
        this.intelligence += attribute.intelligence;
    }

    public void decreaseAttribute(HeroAttribute attribute) {
        this.strength -= attribute.strength;
        this.dexterity -= attribute.dexterity;
        this.intelligence -= attribute.intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
