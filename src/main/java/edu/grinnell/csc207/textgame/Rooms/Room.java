package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Room {
    protected Inventory inventory;
    protected Parser parser;
    protected boolean hasKey;
    protected Scanner scanner = new Scanner(System.in);
    protected HashMap<String, NPC> npcs = new HashMap<>();
    protected HashMap<String, Item> items = new HashMap<>();

    public Room(Inventory inventory, Parser parser) {
        this.inventory = inventory;
        this.parser = parser;
        this.hasKey = false;
    }

    public abstract void waitTurn();
    public abstract void go(String direction);

    public void pickUp(String name) {
        Item item = items.get(name.toLowerCase());
        if (item != null) {
            System.out.println("You have picked up the " + item.getName());
            inventory.addItem(item);
        } else {
            System.out.println("No item '" + name + "' here.");
        }
    }

    public void talk(String name) {
        NPC npc = npcs.get(name.toLowerCase());
        if (npc != null) {
            npc.response();
            System.out.println("You have successfully talked to " + npc.getName());
        } else {
            System.out.println("No one named '" + name + "' here.");
        }
    }

    public void use(String name) {
        Item item = items.get(name.toLowerCase());
        if (item != null) {
            if (inventory.hasItem(item)) {
                item.interact();
            } else {
                System.out.println("You do not have the " + item.getName() + " in your inventory");
            }
        } else {
            System.out.println("No item '" + name + "' to use.");
        }
    }

    public void attack(String name) {
        NPC npc = npcs.get(name.toLowerCase());
        if (npc != null) {
            System.out.println("You have successfully removed " + npc.getName() + " from your network");
        } else {
            System.out.println("No one named '" + name + "' here.");
        }
    }

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
