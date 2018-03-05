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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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
        try
        {
            return bll.sendMessage(message);
        }
        catch (BLLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not send message!: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return null;
        }
    }
}
