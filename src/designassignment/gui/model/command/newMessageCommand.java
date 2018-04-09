/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model.command;

import designassignment.be.Message;
import designassignment.bll.CommandException;
import designassignment.bll.GUIException;
import designassignment.gui.model.MainModel;

/**
 *
 * @author janvanzetten
 */
public class newMessageCommand implements Command
{

    private String messageText;
    private Message thisMessage;
    private MainModel mainModel;

    public newMessageCommand(String messageText, MainModel mModel)
    {
        this.messageText = messageText;
        mainModel = mModel;
    }

    @Override
    public void execute() throws CommandException
    {
        try
        {
            thisMessage = mainModel.sendMessage(messageText);
        }
        catch (GUIException ex)
        {
            throw new CommandException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void undo() throws CommandException
    {
        mainModel.deleteMessage(thisMessage);
    }

}
