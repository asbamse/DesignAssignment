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
public interface DAO
{
    /**
     * get all the messages from the database
     *
     * @return
     * @throws DALException
     */
    public List<Message> getAllMessages() throws DALException;

    /**
     * add a new message
     *
     * @param message
     * @return if there is no exeption it will return a new message object with
     * the given text
     * @throws DALException
     */
    public Message saveNewMessage(String message) throws DALException;
}
