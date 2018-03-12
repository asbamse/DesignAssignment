/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.be.Message;
import designassignment.bll.BLLException;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;

/**
 *
 * @author janvanzetten
 */
public class newMessageCommand implements Command{
    
    private String messageText;
    private Message thisMessage;
    private BLLFacade bll = BLLManager.getInstance();

    public newMessageCommand(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public void execute() throws BLLException {
        thisMessage = bll.sendMessage(messageText);
    }

    @Override
    public void undo() {
        bll.deleteMessage(thisMessage);
    }
    
  
}
