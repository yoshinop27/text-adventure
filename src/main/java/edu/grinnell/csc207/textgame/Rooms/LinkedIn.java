package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Parser;

/**
 * The LinkedIn room
 */
public class LinkedIn extends Room {

    /**
     * Constructor
     * @param inventory the player's inventory
     */
    public LinkedIn(Inventory inventory) {
        super(inventory);
        npcs.put("kevin", new NPC("Kevin",
            "I'm an intern at the Bay Area YC",
            "I'm interested in building B2B SaaS products"));
        npcs.put("chad", new NPC("Chad",
            "I'm a finance bro",
            "I made tons of money doing investment banking"));
        npcs.put("john", new NPC("John",
            "I'm a LinkedIn warrior",
            "I specialize in connecting with LinkedInfluencers"));
        items.put("connection", new Item("Connection Power-Up",
            "A power up to help you instantly get 500+ connections!",
            "You now have 500+ connections!"));
    }

    @Override
    public String getDescription() {
        return "You are in the LinkedIn room. Make connections!";
    }

    @Override
    public void waitTurn() {
        System.out.println("Check your LinkedIn for new connections!");
    }

    @Override
    public void go(String direction, Parser parser) {
        switch (direction) {
            case "north":
                System.out.println("Write a coffee chat request!");
                System.out.print("Username: ");
                getScanner().nextLine();
                System.out.print("Message: ");
                getScanner().nextLine();
                setHasKey(true);
                break;
            case "east":
                System.out.println("Browse profiles! Use 'look <name>' or 'talk <name'");
                System.out.println("People here: Kevin, John, Chad.");
                break;
            case "west":
                System.out.println("Pick up connection: pick connection");
                break;
            case "south":
                if (hasKey()) {
                    parser.setCurrentRoom(new Application(getInventory()));
                    System.out.println("");
                } else {
                    System.out.println("Send a coffee chat first! Go north.");
                }
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
