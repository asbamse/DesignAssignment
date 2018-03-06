/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.Message;
import designassignment.dal.DALException;
import designassignment.dal.DALFacade;
import designassignment.dal.DALManager;
import designassignment.dal.DALManagerXML;
import java.util.List;

/**
 *
 * @author Asbamz
 */
public class BLLManager implements BLLFacade
{
    DALFacade dal;

    /**
     * BLLManager constructor.
     */
    public BLLManager()
    {
        this.dal = new DALManager();
    }

    /**
     * Send message.
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message) throws BLLException
    {
        try
        {
            return dal.sendMessage(message);
        }
        catch (DALException ex)
        {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public List<Message> getMessages() throws BLLException
    {
        try
        {
            return dal.getMessages();
        }
        catch (DALException ex)
        {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

}
