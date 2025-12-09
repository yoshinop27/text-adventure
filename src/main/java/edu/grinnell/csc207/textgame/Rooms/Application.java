package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Parser;

public class Application extends Room {

    public Application(Inventory inventory, Parser parser) {
        super(inventory, parser);    
        // adding room specific objects
        npcs.put("cindy", new NPC("Cindy", "Hi I am a recruiter for Text-Adventure.ai", "Unfortunately, I am not responding to messages at the moment, but feel free to apply on our website"));
        items.put("referral", new Item("Referral", "One of your connections works at this company and can refer you!", "You have been referred to this internship position, be sure to apply!"));
    }

    @Override
    public void waitTurn() {
        System.out.println("Make sure to submit your application on our website!");
    }

    @Override
    public void go(String direction) {
        switch (direction) {
            case "north":
                System.out.println("Please provide information about yourself and your skills to the recruiter!");
                scanner.nextLine();
                break;
            case "east":
                System.out.println("Talk to Cindy the recruiter: talk cindy");
                break;
            case "west":
                System.out.println("Pick up the referral: pick referral");
                break;
            case "south":
                parser.setCurrentRoom(new Interview(inventory, parser));
                System.out.println("You have successfully left the room!");
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
