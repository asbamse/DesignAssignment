/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import designassignment.be.Message;
import designassignment.bll.BLLException;
import designassignment.bll.CommandException;
import designassignment.gui.model.command.Command;
import designassignment.gui.model.MainModel;
import designassignment.gui.model.command.newMessageCommand;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

/**
 *
 * @author Asbamz
 */
public class MainController implements Initializable
{

    @FXML
    private ListView<Message> lstvwMessages;
    @FXML
    private TextArea txtareaMessage;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnRedo;
    @FXML
    private Button btnUndo;

    private MainModel mm;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    /**
     * Initialize window.
     *
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
                                    text = new Text();

                                    if (item.getUserId() == mm.getCurrentUser().getId())
                                    {
                                        text.setText(item.getMessage() + " :" + item.getUserId());
                                        text.setTextAlignment(TextAlignment.RIGHT);
                                    }
                                    else
                                    {
                                        text.setText(item.getUserId() + ": " + item.getMessage());
                                    }

                                    text.setWrappingWidth(lstvwMessages.getWidth() - scrollWidth);
                                    setGraphic(text);

                                }
                                else
                                {
                                    setGraphic(null);
                                }

                            }
                        };
                        return cell;
                    }
                });

                lstvwMessages.widthProperty().addListener((observable, oldValue, newValue)
                        ->
                {
                    lstvwMessages.refresh();
                });

                mm.addListener((c)
                        ->
                {
                    onUpdate();
                });

                onUpdate();
            }
        });

        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    /**
     * Handles press on send button.
     *
     * @param event
     */
    @FXML
    private void handleSend(ActionEvent event) throws BLLException
    {
        sendMessage();
    }

    /**
     * Clear textfield, Focus textfield and scroll down to latest message.
     */
    private void onUpdate()
    {
        txtareaMessage.clear();
        txtareaMessage.requestFocus();
        if (lstvwMessages.getItems() != null)
        {
            if (lstvwMessages.getItems().size() > 0)
            {
                lstvwMessages.scrollTo(lstvwMessages.getItems().get(lstvwMessages.getItems().size() - 1));
            }
        }
    }

    @FXML
    private void handleRedo(ActionEvent event) throws BLLException
    {
        if (!redoStack.empty())
        {
            Command redo = redoStack.pop();
            try
            {
                redo.execute();
                undoStack.push(redo);
            }
            catch (CommandException ex)
            {
                redoStack.push(redo);
                Alert alert = new Alert(Alert.AlertType.WARNING, "Could not redo message!: " + ex.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleUndo(ActionEvent event)
    {
        if (!undoStack.empty())
        {
            Command undo = undoStack.pop();
            try
            {
                undo.undo();
                redoStack.push(undo);
            }
            catch (CommandException ex)
            {
                undoStack.push(undo);
                Alert alert = new Alert(Alert.AlertType.WARNING, "Could not undo message!: " + ex.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void refreshAction(ActionEvent event)
    {
        mm.getAllMessages();
    }

    @FXML
    private void handleKeyEvent(KeyEvent event) throws BLLException
    {
        if (event.getCode() == KeyCode.ENTER && event.isShiftDown())
        {
            txtareaMessage.setText(txtareaMessage.getText() + "\n");
            txtareaMessage.positionCaret(txtareaMessage.getText().length());
        }
        else if (event.getCode() == KeyCode.ENTER)
        {
            sendMessage();
            event.consume();
        }
    }

    private void sendMessage() throws BLLException
    {
        Command message = new newMessageCommand(txtareaMessage.getText(), mm);
        try
        {
            message.execute();
            undoStack.push(message);
            redoStack.clear();
        }
        catch (CommandException ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not send message!: " + ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
}
