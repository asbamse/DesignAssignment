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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

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

    /**
     * Initialize window.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        mm = new MainModel();
        lstvwMessages.setItems(mm.getMessages());
        lstvwMessages.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>()
        {
            @Override
            public ListCell<Message> call(ListView<Message> param)
            {
                ListCell<Message> cell = new ListCell<Message>()
                {
                    @Override
                    protected void updateItem(Message item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (item != null)
                        {
                            setText(item.getMessage());
                        }
                    }
                };
                return cell;
            }
        });

        mm.addListener((c) ->
        {
            onUpdate();
        });

        // Focus textField on run.
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                onUpdate();
            }
        });
    }

    /**
     * Handles press on send button.
     * @param event
     */
    @FXML
    private void handleSend(ActionEvent event)
    {
        mm.sendMessage(txtfldMessage.getText());
    }

    /**
     * Clear textfield, Focus textfield and scroll down to latest message.
     */
    private void onUpdate()
    {
        txtfldMessage.clear();
        txtfldMessage.requestFocus();
        lstvwMessages.scrollTo(lstvwMessages.getItems().get(lstvwMessages.getItems().size() - 1));

    }
}
