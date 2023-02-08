package se.melhed.heroes;

public class Ranger extends Hero{
    private String name;
    private int level;
    private HeroAttribute levelAttributes = new HeroAttribute(1, 7, 1);

    public Ranger(String name) {
        super(name);
    }

    public void levelUp() {
        this.level++;
        this.levelAttributes.levelUpAttribute(1, 5, 1);
    }
}
