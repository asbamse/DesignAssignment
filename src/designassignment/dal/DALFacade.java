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
public interface DALFacade
{
    /**
     * Send message.
     * @param message
     * @return
     */
    public Message sendMessage(String message) throws DALException;
    
    
    /**
     * get a list of all saved messages
     * @return a list og message objects
     */
    public List<Message> getMessages();
}
