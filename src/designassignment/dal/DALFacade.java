/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import designassignment.be.User;
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
     * @throws designassignment.dal.DALException
     */
    public Message sendMessage(String message) throws DALException;
    
    
    /**
     * get a list of all saved messages
     * @return a list og message objects
     */
    public List<Message> getMessages() throws DALException;

    public void deleteMessage(Message thisMessage) throws DALException;
    
    
    /**
     * 
     * @param name the name
     * @param Email the email
     * @param password a encrypted password
     * @return the made user
     */
    public User addUser(String name, String Email, String password) throws DALException;
    
    
    /**
     * 
     * @param Email the email given when the user was added
     * @param password encrypted password using the same encryption as when the user was added
     * @return mathcing user with same password and email
     */
    public User userLogin(String Email, String password) throws DALException;
}
