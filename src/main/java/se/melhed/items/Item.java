package se.melhed.items;

public abstract class Item {
    protected final String name;
    protected final int requiredLevel;
    protected Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
    }

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
