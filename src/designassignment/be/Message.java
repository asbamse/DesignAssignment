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
    private int userId;

    public Message(int id, String message, int userId)
    {
        this.id = id;
        this.message = message;
        this.userId = userId;
    }

    public int getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public int getUserId()
    {
        return userId;
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
