package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Parser;

public class LinkedIn extends Room {

    public LinkedIn(Inventory inventory, Parser parser) {
        super(inventory, parser);
        
        npcs.put("kevin", new NPC("Kevin", "I'm an intern at the Bay Area YC", "I'm interested in building B2B SaaS products"));
        npcs.put("chad", new NPC("Chad", "I'm a finance bro", "I made tons of money doing investment banking then pivoted to private equity"));
        npcs.put("john", new NPC("John", "I'm a LinkedIn warrior", "I specialize in connecting with LinkedInfluencers and cold outreach"));
        
        items.put("connection", new Item("Connection Power-Up", "A power up to help you instantly get 500+ connections!", "You now have 500+ connections!"));
    }

    @Override
    public void waitTurn() {
        System.out.println("Make sure to check your LinkedIn for new connections and messages!");
    }

    @Override
    public void go(String direction) {
        switch (direction) {
            case "north":
                System.out.println("Give a username and write a message to the user requesting a coffee chat!");
                System.out.print("Username: ");
                scanner.nextLine();
                System.out.print("Message: ");
                scanner.nextLine();
                break;
            case "east":
                System.out.println("Browse other profiles! Try the look or talk commands.");
                System.out.println("People here: Kevin, John, Chad");
                break;
            case "west":
                System.out.println("Pick up the connection power-up: pick connection");
                break;
            case "south":
                if (hasKey) {
                    parser.setCurrentRoom(new Interview(inventory, parser));
                    System.out.println("You have successfully left the room!");
                } else {
                    System.out.println("You do not have the key to leave the room");
                }
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
