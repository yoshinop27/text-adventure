package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;

/**
 * The Interview room 
 */
public class Interview extends Room {

    /**
     * Constructor 
     * @param inventory the player's inventory
     */
    public Interview(Inventory inventory) {
        super(inventory);
        npcs.put("sean", new NPC("Sean",
            "Hi I am a software engineer for Text-Adventure.ai",
            "We'll be reviewing your coding skills today"));
        items.put("leetcode", new Item("Leet Code Power-Up",
            "This leet code power-up will help you pass the interview!",
            "You now have all the DSA knowledge you need!"));
    }

    @Override
    public String getDescription() {
        return "You are in the interview room. Today you will be interivewed!";
    }

    @Override
    public void waitTurn() {
        System.out.println("Time is running out! Pass the interview!");
    }

    @Override
    public void go(String direction, Parser parser) {
        switch (direction) {
            case "north":
                System.out.println("Explain how to reverse a linked-list!");
                getScanner().nextLine();
                System.out.println("You completed the coding challenge!");
                setHasKey(true);
                break;
            case "east":
                System.out.println("Talk to Sean. Use 'talk sean'");
                break;
            case "west":
                System.out.println("Pick up leetcode. Use 'pick leetcode'");
                break;
            case "south":
                if (hasKey()) {
                    parser.setCurrentRoom(new Headquarters(getInventory()));
                    System.out.println("");
                } else {
                    System.out.println("Complete the challenge! Go north.");
                }
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
