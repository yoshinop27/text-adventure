package edu.grinnell.csc207.textgame;

import java.util.Scanner;
import edu.grinnell.csc207.textgame.Rooms.*;
import java.util.HashSet;

public class TextAdventure {
    public static void main(String[] args) {
        // Create inventory and parser
        Inventory inventory = new Inventory();
        HashSet<String> used_items = new HashSet<>();
        HashSet<String> network = new HashSet<>();
        
        // Initialize parser with initial room - application
        Parser parser = new Parser(new LinkedIn(inventory), used_items, network);

        System.out.println("Welcome to the Text Adventure!");
        System.out.println("You are a computer science student looking for an internship");

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Print initial room description
        System.out.println(parser.currentRoom.getDescription());

        // Start game loop
        while (!parser.isGameOver) {
            System.out.print("> ");
            String input = scanner.nextLine();
            parser.parse(input);
        }

        scanner.close();
    }
}
