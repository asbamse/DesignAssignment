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
 * @author janvanzetten
 */
public class DALManagerXML implements DALFacade
{
    DAO xmldao = new XML_DAO();

    private static DALManagerXML instance;

    /**
     * Singleton method.
     * @return
     */
    public static DALManagerXML getInstance()
    {
        if (instance == null)
        {
            instance = new DALManagerXML();
        }
        return instance;
    }

    /**
     * Constructor.
     */
    private DALManagerXML()
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
        return xmldao.saveNewMessage(message);
    }

    /**
     * Get message.
     * @return
     * @throws DALException
     */
    @Override
    public List<Message> getMessages() throws DALException
    {
        return xmldao.getAllMessages();
    }

    @Override
    public void deleteMessage(Message thisMessage) throws DALException
    {
        xmldao.deleteMessage(thisMessage);
    }
}
