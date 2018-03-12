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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Asbamz
 */
public class MainModel
{
    BLLFacade bll;
    private ObservableList<Message> messages;

    /**
     * Main model constructor.
     */
    public MainModel()
    {
        this.bll = BLLManager.getInstance();
        messages = FXCollections.observableArrayList();
        getAllMessages();
    }

    public ObservableList<Message> getMessages()
    {
        return messages;
    }

    /**
     * Send message
     * @param message
     * @return
     */
    public Message sendMessage(String message)
    {
        try
        {
            Message tmp = bll.sendMessage(message);
            messages.add(tmp);
            return tmp;
        }
        catch (BLLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not send message!: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return null;
        }
    }

    private void getAllMessages()
    {
        messages.clear();
        try
        {
            List<Message> allMessages = bll.getMessages();
            if (allMessages != null)
            {
                messages.addAll(bll.getMessages());
            }
        }
        catch (BLLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not get messages!: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void addListener(ListChangeListener cl)
    {
        messages.addListener(cl);
    }
}
