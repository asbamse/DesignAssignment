/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Asbamz
 */
public class Message
{
    private int id;
    private String message;

    public Message()
    {
    }

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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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
