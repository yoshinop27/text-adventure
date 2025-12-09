package edu.grinnell.csc207.textgame.Objects;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;

public class NPC implements Lookable {
    private String name;
    private String message;
    private String response;

    /**
     * Constructor
     * @param name
     * @param message
     */
    public NPC (String name, String message, String response) {
        this.name = name;
        this.message = message;
        this.response = response;
    }

    /**
     * Response to user when they look at this NPC
     */
    public void lookAt () {
        System.out.println("Hi my name is " + this.name + " " + this.message);
    }

    /**
     * Response to user when they talk to this NPC
     */
    public void response () {
        System.out.println(this.response);
    }

    /**
     * Get the name of the NPC
     * @return
     */
    public String getName () {
        return this.name;
    }
}
