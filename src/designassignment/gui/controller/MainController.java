/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import designassignment.be.Message;
import designassignment.gui.model.MainModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Asbamz
 */
public class MainController implements Initializable
{
    private Label label;
    @FXML
    private ListView<Message> lstvwMessages;
    @FXML
    private TextField txtfldMessage;

    private MainModel mm;
    private ObservableList<Message> messages;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        mm = new MainModel();
        messages = FXCollections.observableArrayList();
        lstvwMessages.setItems(messages);
    }

    @FXML
    private void handleSend(ActionEvent event)
    {
        messages.add(mm.sendMessage(txtfldMessage.getText()));
    }
}
