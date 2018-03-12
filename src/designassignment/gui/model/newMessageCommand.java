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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void execute() {
        try {
            thisMessage = bll.sendMessage(messageText);
        } catch (BLLException ex) {
            Logger.getLogger(newMessageCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        try {
            bll.deleteMessage(thisMessage);
        } catch (BLLException ex) {
            Logger.getLogger(newMessageCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}
