/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import java.util.List;

/**
 *
 * @author Asbamz
 */
public class DALManager implements DALFacade
{
    /**
     * Send message.
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message)
    {
        return new Message(message);
    }

    @Override
    public List<Message> getMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
