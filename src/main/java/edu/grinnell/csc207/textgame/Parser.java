package edu.grinnell.csc207.textgame;

import edu.grinnell.csc207.textgame.Rooms.Room;
import java.util.HashSet;

/**
 * Parser class to handle user input and drive game
 */
public class Parser {
    // current room
    private Room currentRoom;
    // game state
    private boolean isGameOver = false;
    // hashsets tracking players states
    private HashSet<String> network = new HashSet<>();
    private HashSet<String> usedItems = new HashSet<>();

    /**
     * Constructor for parser
     * @param room the starting room
     */
    public Parser(Room room) {
        this.currentRoom = room;
        this.network = new HashSet<>();
        this.usedItems = new HashSet<>();
    }

    /**
     * Sets the current room
     * @param room the new room, or null to end the game
     */
    public void setCurrentRoom(Room room) {
        if (room == null) {
            isGameOver = true;
            return;
        }
        this.currentRoom = room;
        System.out.println(room.getDescription());
    }

    /**
     * Gets the current room
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Checks if the game is over
     * @return true if the game is over
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * Add to the user's network
     * @param name 
     */
    public void addToNetwork(String name) {
        network.add(name);
    }

    /**
     * Removes a user from the network
     * @param name the name to remove
     */
    public void removeFromNetwork(String name) {
        network.remove(name);
    }

    /**
     * Gets the size of the network
     * @return the network size
     */
    public int getNetworkSize() {
        return network.size();
    }

    /**
     * Adds an item to the used items set
     * @param name 
     */
    public void addUsedItem(String name) {
        usedItems.add(name);
    }

    /**
     * Gets the number of used items
     * @return used items size
     */
    public int getUsedItemsSize() {
        return usedItems.size();
    }

    /**
     * Parses user input and executes the appropriate command
     * @param input the user input
     */
    public void parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] parts = input.trim().toLowerCase().split(" ", 2);
        String cmd = parts[0];
        String arg = parts.length > 1 ? parts[1] : "";

        switch (cmd) {
            case "go" -> currentRoom.go(arg, this);
            case "wait" -> currentRoom.waitTurn();
            case "pick" -> currentRoom.pickUp(arg);
            case "talk" -> currentRoom.talk(arg, this);
            case "use" -> currentRoom.use(arg, this);
            case "attack" -> currentRoom.attack(arg, this);
            case "look" -> currentRoom.lookAt(arg);
            case "quit" -> {
                System.out.println("Thanks for playing!");
                isGameOver = true;
            }
            default -> System.out.println("Unknown command: " + cmd);
        }
    }
}
