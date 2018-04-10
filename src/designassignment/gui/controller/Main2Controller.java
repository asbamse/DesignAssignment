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
    @FXML
    private Label lblProgramName;
    @FXML
    private AnchorPane paneTab;

    private Pane paneOptions;
    private Pane panePersonalLogs;
    private Pane paneSharedLogs;
    private Pane paneCollaborators;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            paneOptions = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            panePersonalLogs = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            paneSharedLogs = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            paneCollaborators = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));
            setupAnchor(paneOptions);
            setupAnchor(panePersonalLogs);
            setupAnchor(paneSharedLogs);
            setupAnchor(paneCollaborators);
        }
        catch (IOException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }

        Platform.runLater(() ->
        {
            changePane(panePersonalLogs);
        });
    }

    /**
     * Switch to Options.
     * @param event
     */
    @FXML
    private void handleOptions(ActionEvent event)
    {
        changePane(paneOptions);
    }

    /**
     * Switch to Personal Logs.
     * @param event
     */
    @FXML
    private void handlePersonalLogs(ActionEvent event)
    {
        changePane(panePersonalLogs);
    }

    /**
     * Switch to Shared Logs.
     * @param event
     */
    @FXML
    private void handleSharedLogs(ActionEvent event)
    {
        changePane(paneSharedLogs);
    }

    /**
     * Switch to Collaborators.
     * @param event
     */
    @FXML
    private void handleCollaborators(ActionEvent event)
    {
        changePane(paneCollaborators);
    }

    /**
     * Switch to new pane.
     * @param pane
     */
    private void changePane(Pane pane)
    {
        paneTab.getChildren().clear();
        paneTab.getChildren().add(pane);
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
