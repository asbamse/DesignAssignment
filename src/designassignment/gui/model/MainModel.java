/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.be.Message;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;

/**
 *
 * @author Asbamz
 */
public class MainModel
{
    BLLFacade bll;

    /**
     * Main model constructor.
     */
    public MainModel()
    {
        this.bll = new BLLManager();
    }

    /**
     * Send message
     * @param message
     * @return
     */
    public Message sendMessage(String message)
    {
        return new Message(message);
    }
}
