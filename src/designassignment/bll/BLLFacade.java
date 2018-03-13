/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.Message;
import java.util.List;

/**
 *
 * @author Asbamz
 */
public interface BLLFacade
{
    /**
     * Send message.
     * @param message
     * @return
     */
    public Message sendMessage(String message) throws BLLException;

    /**
     * Get a list of all saved messages.
     * @return a list og message objects
     */
    public List<Message> getMessages() throws BLLException;

    /**
     * delets the given message
     * @param thisMessage
     * @throws BLLException 
     */
    public void deleteMessage(Message thisMessage)throws BLLException;
    
    /**
     * Creates a new user.
     * @param username
     * @param email
     * @param password
     * @throws BLLException 
     */
    public void createUser(String username, String email, String password) throws BLLException;
}
