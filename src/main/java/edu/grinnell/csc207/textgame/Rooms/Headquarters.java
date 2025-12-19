package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;
import java.util.Scanner;

/**
 * Headquarters room where players find out their application status
 */
public class Headquarters extends Room {

    // win requirements
    private static int MIN_NETWORK_SIZE = 5;
    private static int MIN_ITEMS_USED = 4;

    /**
     * Constructor for the Headquarters room
     * @param inventory the player's inventory
     */
    public Headquarters(Inventory inventory) {
        super(inventory);
        npcs.put("brian", new NPC("Brian",
            "Hi I am a software engineering manager",
            "Congratulations! You got the internship!"));
        npcs.put("john", new NPC("John",
            "Hi I am also applying here",
            "My dad works here and told me about this!"));
        items.put("tshirt", new Item("T-Shirt",
            "A t-shirt from Text-Adventure.ai",
            "Thanks for completing the interview process!"));
    }

    @Override
    public String getDescription() {
        return "You are in the headquarters room. Are you exicted to know your application status?!";
    }

    @Override
    public void waitTurn() {
        System.out.println("Relax and don't stress too much!");
    }

    @Override
    public void talk(String name, Parser parser) {
        if (name.toLowerCase().equals("brian")) {
            if (parser.getNetworkSize() >= MIN_NETWORK_SIZE
                && parser.getUsedItemsSize() >= MIN_ITEMS_USED) {
                System.out.println("You have been accepted! Congratulations!");
                parser.setCurrentRoom(null);
            } else {
                System.out.println("You have been rejected. We decided to hire John instead. His dad works here and told me about his application!");
                parser.setCurrentRoom(null);
            }
        } else {
            super.talk(name, parser);
        }
    }

    @Override
    public void go(String direction, Parser parser) {
        switch (direction) {
            case "north":
                System.out.println("Send a thank you email!");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                break;
            case "east":
                System.out.println("Pick up a t-shirt. Use 'pick tshirt'");
                break;
            case "west":
                System.out.println("Interact with John. Use 'look john' or 'talk john'");
                break;
            case "south":
                System.out.println("Talk to Brian. Use 'talk brian'");
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
