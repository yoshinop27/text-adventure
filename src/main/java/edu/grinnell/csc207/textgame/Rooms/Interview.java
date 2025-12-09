package edu.grinnell.csc207.textgame.Rooms;

import edu.grinnell.csc207.textgame.Objects.Item;
import edu.grinnell.csc207.textgame.Objects.NPC;
import edu.grinnell.csc207.textgame.Inventory;
import edu.grinnell.csc207.textgame.Parser;

public class Interview extends Room {

    public Interview(Inventory inventory, Parser parser) {
        super(inventory, parser);
        
        npcs.put("sean", new NPC("Sean", "Hi I am a software engineer for Text-Adventure.ai", "Today we are going to be reviewing your coding skills and your ability to think critically"));
        
        items.put("leetcode", new Item("Leet Code Power-Up", "This leet code power-up will help you pass the interview!", "This power-up will give you all of the DSA knowledge you need to pass the interview!"));
    }

    @Override
    public void waitTurn() {
        System.out.println("Time is running out! You need to pass the interview to get the internship!");
    }

    @Override
    public void go(String direction) {
        switch (direction) {
            case "north":
                System.out.println("You will conduct an asynchronous coding challenge to test your coding skills!");
                System.out.println("Given an array of integers nums and an integer target, return the indices of the two numbers that add up to target.");
                scanner.nextLine();
                System.out.println("You have completed the coding challenge!");
                break;
            case "east":
                System.out.println("Talk to Sean the interviewer: talk sean");
                break;
            case "west":
                System.out.println("Pick up the leetcode power-up: pick leetcode");
                break;
            case "south":
                parser.setCurrentRoom(new Headquarters(inventory, parser));
                System.out.println("You have successfully left the room!");
                break;
            default:
                System.out.println("This direction is not valid");
                break;
        }
    }
}
