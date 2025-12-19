package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;
import java.util.HashMap;
import java.util.Scanner;

// Abstract class for all rooms
public abstract class Room {
    // elements of the room
    private Inventory inventory;
    private boolean hasKey;
    private Scanner scanner = new Scanner(System.in);
    public HashMap<String, NPC> npcs;
    public HashMap<String, Item> items;

    /**
     * room constructor
     * @param inv the player's inventory
     */
    public Room(Inventory inv) {
        this.inventory = inv;
        this.hasKey = false;
        this.npcs = new HashMap<>();
        this.items = new HashMap<>();
    }

    /**
     * Gets the player's inventory
     * @return 
     */
    protected Inventory getInventory() {
        return inventory;
    }

    /**
     * Checks if the player has the key
     * @return 
     */
    protected boolean hasKey() {
        return hasKey;
    }

    /**
     * Sets the key status
     * @param key
     */
    protected void setHasKey(boolean key) {
        this.hasKey = key;
    }

    /**
     * central scanner to reduce complexity
     * @return the scanner
     */
    protected Scanner getScanner() {
        return scanner;
    }

    /**
     * Wait for one turn
     */
    public abstract void waitTurn();

    /**
     * Moves in a direction
     * @param direction the direction to move
     * @param parser the parser to use for room transitions
     */
    public abstract void go(String direction, Parser parser);

    /**
     * description for initial loading
     * @return the description of the room
     */
    public abstract String getDescription();

    /**
     * 
     * @param name the name of the item to pick up
     */
    public void pickUp(String name) {
        Item item = items.get(name.toLowerCase());
        if (item != null) {
            System.out.println("You have picked up the " + item.getName());
            inventory.addItem(item);
        } else {
            System.out.println("No item '" + name + "' here.");
        }
    }

    /**
     * talk to an npc and add them to your network
     * @param name the name of the NPC to talk to
     * @param parser 
     */
    public void talk(String name, Parser parser) {
        NPC npc = npcs.get(name.toLowerCase());
        if (npc != null) {
            npc.response();
            parser.addToNetwork(npc.getName());
        } else {
            System.out.println("No one named '" + name + "' here.");
        }
    }

    /**
     * use an item and add to your used list
     * @param name the name of the item to use
     * @param parser 
     */
    public void use(String name, Parser parser) {
        Item item = items.get(name.toLowerCase());
        if (item != null) {
            if (inventory.hasItem(item)) {
                item.interact();
                parser.addUsedItem(item.getName());
            } else {
                System.out.println("You do not have the "
                    + item.getName() + " in your inventory");
            }
        } else {
            System.out.println("No item '" + name + "' to use.");
        }
    }

    /**
     * attack an npc and remove them from your network
     * @param name the name of the NPC to attack
     * @param parser 
     */
    public void attack(String name, Parser parser) {
        NPC npc = npcs.get(name.toLowerCase());
        if (npc != null) {
            System.out.println("You have successfully removed "
                + npc.getName() + " from your network");
            parser.removeFromNetwork(npc.getName());
        } else {
            System.out.println("No one named '" + name + "' here.");
        }
    }

    /**
     * Looks at an object by name
     * @param name the name of the object to look at (must implement lookable)
     */
    public void lookAt(String name) {
        Lookable obj = npcs.get(name.toLowerCase());
        if (obj == null) {
            obj = items.get(name.toLowerCase());
        }
        if (obj != null) {
            obj.lookAt();
        } else {
            System.out.println("Nothing called '" + name + "' here.");
        }
    }
}
