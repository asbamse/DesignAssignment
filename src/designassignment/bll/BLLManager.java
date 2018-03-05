/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.Message;
import designassignment.dal.DALFacade;
import designassignment.dal.DALManager;

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
    public Message sendMessage(String message)
    {
        return dal.sendMessage(message);
    }

}
