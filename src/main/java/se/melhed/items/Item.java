package se.melhed.items;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }

}
