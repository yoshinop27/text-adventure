package edu.grinnell.csc207.textgame;

import edu.grinnell.csc207.textgame.Rooms.LinkedIn;
import java.util.Scanner;

/**
 * Driver for our game
*/
public class TextAdventure {

    /**
     * Main entry point
     */
    public static void main(String[] args) {
        // initalize inventory and parser
        Inventory inventory = new Inventory();
        Parser parser = new Parser(new LinkedIn(inventory));

        // welcome messaging
        System.out.println("Welcome to the Text Adventure!");
        System.out.println(
            "You are a computer science student looking for an internship.\n");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println(parser.getCurrentRoom().getDescription());

        // game loop
        while (!parser.isGameOver()) {
            System.out.print("> ");
            String input = scanner.nextLine();
            parser.parse(input);
        }

        scanner.close();
    }
}
