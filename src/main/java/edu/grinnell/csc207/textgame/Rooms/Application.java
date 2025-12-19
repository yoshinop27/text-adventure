package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;

/**
 * the application room where user will submit their application
 */
public class Application extends Room {

    /**
     * Constructor
     * @param inventory the player's inventory
     */
    public Application(Inventory inventory) {
        super(inventory);
        npcs.put("cindy", new NPC("Cindy",
            "Hi I am a recruiter for Text-Adventure.ai",
            "I'm not responding to messages, but apply on our website"));
        items.put("referral", new Item("Referral",
            "One of your connections can refer you!",
            "You have been referred to this internship position!"));
    }

    @Override
    public String getDescription() {
        return "You are in the application room. Talk to recruiters and fill out an application!";
    }

    @Override
    public void waitTurn() {
        System.out.println("Submit your application on our website!");
    }

    @Override
    public void go(String direction, Parser parser) {
        switch (direction) {
            case "north":
                System.out.println("Provide info about yourself and why we should hire you!");
                getScanner().nextLine();
                setHasKey(true);
                break;
            case "east":
                System.out.println("Talk to Cindy. Use 'talk cindy'");
                break;
            case "west":
                System.out.println("Pick up referral. Use 'pick referral'");
                break;
            case "south":
                if (hasKey()) {
                    parser.setCurrentRoom(new Interview(getInventory()));
                    System.out.println("");
                } else {
                    System.out.println("Submit application first! Go north.");
                }
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
