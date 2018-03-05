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
    
    DB_DAO dbdao = new DB_DAO();
    
    /**
     * Send message.
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message) throws DALException{
        return dbdao.saveNewMessage(message);
    }

    @Override
    public List<Message> getMessages() throws DALException {
        return dbdao.getAllMessages();
    }

}
