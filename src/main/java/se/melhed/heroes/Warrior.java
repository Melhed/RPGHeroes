package se.melhed.heroes;

public class Warrior extends Hero{
    private String name;
    private int level;
    private HeroAttribute levelAttributes = new HeroAttribute(5, 2, 1);
    public Warrior(String name) {
        super(name);
    }

    public void levelUp() {
        this.level++;
        this.levelAttributes.levelUpAttribute(3,2, 1);
    }

}
