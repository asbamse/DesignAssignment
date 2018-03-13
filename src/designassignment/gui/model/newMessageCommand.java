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
 * @author janvanzetten
 */
public class newMessageCommand implements Command{
    
    private String messageText;
    private Message thisMessage;
    private BLLFacade bll = BLLManager.getInstance();
    private MainModel mainModel;

    public newMessageCommand(String messageText, MainModel mModel) {
        this.messageText = messageText;
        mainModel = mModel;
    }

    @Override
    public void execute() {
        thisMessage = mainModel.sendMessage(messageText);
    }

    @Override
    public void undo() {
        mainModel.deleteMessage(thisMessage);
    }
    
  
}
