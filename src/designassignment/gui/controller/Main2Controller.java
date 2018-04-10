/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asbamz
 */
public class Main2Controller implements Initializable
{
    private final int PANE_OPTIONS = 0;
    private final int PANE_PERSONAL_LOGS = 1;
    private final int PANE_SHARED_LOGS = 2;
    private final int PANE_COLLABORATORS = 3;

    @FXML
    private Label lblProgramName;
    @FXML
    private AnchorPane paneTab;
    @FXML
    private Button btnOptions;
    @FXML
    private Button btnPersonalLogs;
    @FXML
    private Button btnSharedLogs;
    @FXML
    private Button btnCollaborators;

    private Pane[] panes;
    private Button[] buttons;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        panes = new Pane[4];
        buttons = new Button[4];
        try
        {
            panes[PANE_OPTIONS] = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            panes[PANE_PERSONAL_LOGS] = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            panes[PANE_SHARED_LOGS] = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            panes[PANE_COLLABORATORS] = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            buttons[PANE_OPTIONS] = btnOptions;
            buttons[PANE_PERSONAL_LOGS] = btnPersonalLogs;
            buttons[PANE_SHARED_LOGS] = btnSharedLogs;
            buttons[PANE_COLLABORATORS] = btnCollaborators;

            for (int i = 0; i < 4; i++)
            {
                setupAnchor(panes[i]);
            }
        }
        catch (IOException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }

        Platform.runLater(() ->
        {
            changePane(PANE_PERSONAL_LOGS);
        });
    }

    /**
     * Switch to Options.
     * @param event
     */
    @FXML
    private void handleOptions(ActionEvent event)
    {
        changePane(PANE_OPTIONS);
    }

    /**
     * Switch to Personal Logs.
     * @param event
     */
    @FXML
    private void handlePersonalLogs(ActionEvent event)
    {
        changePane(PANE_PERSONAL_LOGS);
    }

    /**
     * Switch to Shared Logs.
     * @param event
     */
    @FXML
    private void handleSharedLogs(ActionEvent event)
    {
        changePane(PANE_SHARED_LOGS);
    }

    /**
     * Switch to Collaborators.
     * @param event
     */
    @FXML
    private void handleCollaborators(ActionEvent event)
    {
        changePane(PANE_COLLABORATORS);
    }

    /**
     * Switch to new pane.
     * @param pane
     */
    private void changePane(int pane)
    {
        paneTab.getChildren().clear();
        paneTab.getChildren().add(panes[pane]);
        updateButton(buttons[pane]);
    }

    private void updateButton(Button btn)
    {
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].setStyle("");
        }
        btn.setStyle(btn.getStyle() + " -fx-background-color: #00377F, #46a2f8; -fx-background-insets: 0, 1.5 0.5 0 0.5;");
    }

    /**
     * Sets up the Anchor for tab pane.
     * @param pane
     */
    private void setupAnchor(Pane pane)
    {
        AnchorPane.setTopAnchor(pane, 5.0);
        AnchorPane.setBottomAnchor(pane, 5.0);
        AnchorPane.setLeftAnchor(pane, 5.0);
        AnchorPane.setRightAnchor(pane, 5.0);
    }
}
