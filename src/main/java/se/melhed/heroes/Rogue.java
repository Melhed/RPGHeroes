package se.melhed.heroes;

public class Rogue extends Hero{
    private String name;
    private int level;
    private HeroAttribute levelAttributes = new HeroAttribute(2, 6, 1);

    public Rogue(String name) {
        super(name);
    }

    public void levelUp() {
        this.level++;
        this.levelAttributes.levelUpAttribute(1, 4, 1);
    }
}
