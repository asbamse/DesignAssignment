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

    public Message(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}
