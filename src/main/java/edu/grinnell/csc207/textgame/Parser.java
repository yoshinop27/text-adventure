package edu.grinnell.csc207.textgame;

import edu.grinnell.csc207.textgame.Rooms.Room;

public class Parser {
    private Room currentRoom;

    public Parser(Room room) {
        this.currentRoom = room;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void parse(String input) {
        if (input == null || input.trim().isEmpty()) return;

        String[] parts = input.trim().toLowerCase().split(" ", 2);
        String cmd = parts[0];
        String arg = ""; 
        if (parts.length > 1){
            arg = parts[1];
        }

        // handle different commands
        switch (cmd) {
            case "go" -> currentRoom.go(arg);
            case "wait" -> currentRoom.waitTurn();
            case "pick" -> currentRoom.pickUp(arg);
            case "talk" -> currentRoom.talk(arg);
            case "use" -> currentRoom.use(arg);
            case "attack" -> currentRoom.attack(arg);
            case "look" -> currentRoom.lookAt(arg);
            default -> System.out.println("Unknown command: " + cmd);
        }
    }
}
