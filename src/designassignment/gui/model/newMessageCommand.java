/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.gui.model.Command;
import designassignment.be.Message;
import designassignment.bll.BLLException;
import designassignment.dal.DALException;
import designassignment.dal.DALFacade;

/**
 *
 * @author janvanzetten
 */
public class newMessageCommand implements Command{
    
    String messageText;
    DALFacade dal;
    Message thisMessage;

    public newMessageCommand(String messageText, DALFacade dal) {
        this.messageText = messageText;
    }

    @Override
    public void execute() throws BLLException {
        try
        {
            thisMessage = dal.sendMessage(messageText);
        }
        catch (DALException ex)
        {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void undo() {
        dal.deleteMessage(thisMessage);
    }
    
    public Message getMessage(){
        return thisMessage;
    }
    
}
