/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.be;

/**
 *
 * @author Asbamz
 */
public class Message
{
    private String message;
    private int id;

    /**
     * Message constructor.
     * @param message
     */
    public Message(String message)
    {
        this.message = message;
    }
    
    /**
     * Message constructor.
     * @param message
     */
    public Message(String message, int id)
    {
        this.message = message;
        this.id = id;
    }

    /**
     * Get message.
     * @return
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Message to String.
     * @return
     */
    @Override
    public String toString()
    {
        return message;
    }
}
