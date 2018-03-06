/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.be;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asbamz
 */

@XmlRootElement
public class Message
{
    private String message;
    private int id;

    public Message() {
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

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }
    
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    
    
}
