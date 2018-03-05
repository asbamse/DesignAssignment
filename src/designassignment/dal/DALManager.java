/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;

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

}
