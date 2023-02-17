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

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttribute other = (HeroAttribute) o;
        return strength == other.strength && dexterity == other.dexterity && intelligence == other.intelligence;
    }

}
