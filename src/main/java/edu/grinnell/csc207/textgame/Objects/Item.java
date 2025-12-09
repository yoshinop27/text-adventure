package edu.grinnell.csc207.textgame.Objects;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;

public class Item implements Lookable {
    private String name;
    private String function;
    private String interactMessage;

    /**
     * @param name
     * @param function
     */
    public Item (String name, String function, String interactMessage) {
        this.name = name;
        this.function = function;
        this.interactMessage = interactMessage;
    }

    /**
     * Interact with the item, display message
     */
    public void lookAt () {
        System.out.println("You are looking at the " + this.name + ". " + this.function);
    }

    /**
     * Get the name of the item
     * @return the name of the item
     */ 
    public String getName() {
        return this.name;
    }

    /**
     * Interact with the item
     */
    public void interact() {
        System.out.println(this.interactMessage);
    }
}
