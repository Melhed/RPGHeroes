package se.melhed.heroes;

public class Mage extends Hero{
    private String name;
    private int level;
    private HeroAttribute levelAttributes = new HeroAttribute(1, 1, 8);

    public Mage(String name) {
        super(name);
    }

    public void levelUp() {
        this.levelAttributes.levelUpAttribute(1, 1, 5);
        this.level++;
    }
}
