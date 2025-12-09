package edu.grinnell.csc207.textgame;

import java.util.ArrayList;
import java.util.List;
import edu.grinnell.csc207.textgame.Objects.Item;

public class Inventory {
    private List<Item> items;

    /**
     * Constructor
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }
    
    /**
     * Add an item to the inventory
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    /**
     * Remove an item from the inventory
     * @param item
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    /**
     * @return list of items in the inventory
     */
    public List<Item> getItems() {
        return this.items;
    }
    
    /**
     * Check if an item is in the inventory
     * @param item
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean hasItem(Item item) {
        return this.items.contains(item);
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("=== Inventory ===");
            for (Item item : items) {
                System.out.println("  - " + item.getName());
            }
        }
    }
}
