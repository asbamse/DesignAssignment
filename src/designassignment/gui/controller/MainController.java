/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import designassignment.be.Message;
import designassignment.gui.model.Command;
import designassignment.gui.model.MainModel;
import designassignment.gui.model.newMessageCommand;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnRedo;
    @FXML
    private Button btnUndo;

    private MainModel mm;
    private ArrayList<Command> undoStack;

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

        // Focus textField on run.
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                double scrollbarWidth = 50;
                for (Node node : lstvwMessages.lookupAll(".scroll-bar"))
                {
                    if (node instanceof ScrollBar)
                    {
                        ScrollBar bar = (ScrollBar) node;
                        if (bar.getOrientation().equals(Orientation.VERTICAL))
                        {
                            scrollbarWidth = bar.getWidth();
                        }
                        else if (bar.getOrientation().equals(Orientation.HORIZONTAL))
                        {
                            bar.setDisable(true);
                        }
                    }
                }

                System.out.println(lstvwMessages.getWidth());
                System.out.println(scrollbarWidth);
                final double finalScrollbarWidth = scrollbarWidth;
                lstvwMessages.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>()
                {
                    @Override
                    public ListCell<Message> call(ListView<Message> param)
                    {
                        ListCell<Message> cell = new ListCell<Message>()
                        {
                            private Text text;
                            private double scrollWidth = finalScrollbarWidth * 2.2;

                            @Override
                            protected void updateItem(Message item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if (item != null)
                                {
                                    text = new Text(item.getMessage());
                                    text.setWrappingWidth(lstvwMessages.getWidth() - scrollWidth);
                                    setGraphic(text);
                                }
                            }
                        };
                        return cell;
                    }
                });

                lstvwMessages.widthProperty().addListener((observable, oldValue, newValue) ->
                {
                    lstvwMessages.refresh();
                });

                mm.addListener((c) ->
                {
                    onUpdate();
                });

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
        Command message = new newMessageCommand(txtfldMessage.getText(), mm);
        undoStack.add(message);

    }

    /**
     * Clear textfield, Focus textfield and scroll down to latest message.
     */
    private void onUpdate()
    {
        txtfldMessage.clear();
        txtfldMessage.requestFocus();
        if (lstvwMessages.getItems() != null)
        {
            if (lstvwMessages.getItems().size() > 0)
            {
                lstvwMessages.scrollTo(lstvwMessages.getItems().get(lstvwMessages.getItems().size() - 1));
            }
        }
    }

    @FXML
    private void handleRedo(ActionEvent event)
    {
    }

    @FXML
    private void handleUndo(ActionEvent event)
    {
        for (int i = 0; i < undoStack.size(); i++)
        {
            undoStack.get(i).undo();
        }

    }
}
