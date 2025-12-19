package edu.grinnell.csc207.textgame.Objects;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;

/**
 * A class representing an item in the game that can be picked up and used.
 */
public class Item implements Lookable {
    // Core components of an item
    private String name;
    private String function;
    private String interactMsg;

    /**
     * Constructor
     *
     * @param itemName 
     * @param itemFunction the description of what the item does
     * @param intMsg the message displayed when interacting (use)
     */
    public Item(String itemName,
                String itemFunction,
                String intMsg) {
        this.name = itemName;
        this.function = itemFunction;
        this.interactMsg = intMsg;
    }

    /**
     * Displays the function when looking at this item
     */
    @Override
    public void lookAt() {
        System.out.println("You are looking at the "
            + this.name + ". " + this.function);
    }

    /**
     *
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Displays the interaction message
     */
    public void interact() {
        System.out.println(this.interactMsg);
    }
}
