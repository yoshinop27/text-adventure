package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Parser;

public class Headquarters extends Room {

    public Headquarters(Inventory inventory, Parser parser) {
        super(inventory, parser);
        // adding room specific objects
        npcs.put("brian", new NPC("Brian", "Hi I am a software engineering manager for Text-Adventure.ai", "Unfortunately, we have filled the internship positions for this year, but feel free to apply next year!"));
        npcs.put("john", new NPC("John", "Hi I am also applying to be a software engineer for Text-Adventure.ai", "My dad works here and he told me about the internship program!"));
        
        items.put("tshirt", new Item("T-Shirt", "A t-shirt from Text-Adventure.ai", "You have picked up a t-shirt from Text-Adventure.ai! Thanks for completing the interview process"));
    }

    @Override
    public void waitTurn() {
        System.out.println("Relax and don't stress too much!");
    }

    @Override
    public void go(String direction) {
        switch (direction) {
            case "north":
                System.out.println("Send an email to the interviewer to thank them for the opportunity!");
                scanner.nextLine();
                break;
            case "east":
                System.out.println("Pick up a t-shirt: pick tshirt");
                break;
            case "west":
                System.out.println("Look at John the other applicant: look john");
                break;
            case "south":
                System.out.println("Talk to Brian the manager: talk brian");
                // End the game condition here
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
