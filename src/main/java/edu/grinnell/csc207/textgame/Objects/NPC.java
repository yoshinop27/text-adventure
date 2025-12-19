package edu.grinnell.csc207.textgame.Objects;

import edu.grinnell.csc207.textgame.Interfaces.Lookable;

/**
 * A class representing our games NPCs.
 */
public class NPC implements Lookable {
    // core components
    private String name;
    private String message;
    private String npcResponse;

    /**
     * Constructor for an NPC
     *
     * @param npcName 
     * @param npcMessage the message when looking at the NPC
     * @param resp the response when talking to the NPC
     */
    public NPC(String npcName,
               String npcMessage,
               String resp) {
        this.name = npcName;
        this.message = npcMessage;
        this.npcResponse = resp;
    }

    /**
     * display a message when user looks at NPC
     */
    @Override
    public void lookAt() {
        System.out.println("Hi my name is " + this.name + " " + this.message);
    }

    /**
     * display a response when user talks to npc
     */
    public void response() {
        System.out.println(this.npcResponse);
    }

    /**
     *
     * @return the name of the NPC
     */
    public String getName() {
        return this.name;
    }
}
