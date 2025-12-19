package edu.grinnell.csc207.textgame;

import edu.grinnell.csc207.textgame.Objects.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * inventory class to manage player's items
 */
public class Inventory {
    // list of users items
    private List<Item> invItems;

    /**
     * initialize empty inventory
     */
    public Inventory() {
        this.invItems = new ArrayList<>();
    }

    /**
     * Add an item to the inventory
     * @param item the item to add
     */
    public void addItem(Item item) {
        this.invItems.add(item);
    }

    /**
     * Removes item from the inventory
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        this.invItems.remove(item);
    }

    /**
     * get the list of items
     * @return list of items in the inventory
     */
    public List<Item> getinvItems() {
        return this.invItems;
    }

    /**
     * Checks if an item is in the inventory
     * @param item the item to check for
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean hasItem(Item item) {
        return this.invItems.contains(item);
    }
}
