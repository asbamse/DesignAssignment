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
    DAO dbdao = new DB_DAO();

    private static DALManager instance;

    /**
     * Singleton method.
     * @return
     */
    public static DALManager getInstance()
    {
        if (instance == null)
        {
            instance = new DALManager();
        }
        return instance;
    }

    /**
     * Constructor.
     */
    private DALManager()
    {
    }

    /**
     * Send message.
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message) throws DALException
    {
        return dbdao.saveNewMessage(message);
    }

    /**
     * Get message.
     * @return
     * @throws DALException
     */
    @Override
    public List<Message> getMessages() throws DALException
    {
        return dbdao.getAllMessages();
    }

}
