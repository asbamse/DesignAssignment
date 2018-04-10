/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import designassignment.bll.VBoxCell;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import designassignment.gui.model.UserModel;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author alexl
 */
public class UserViewController implements Initializable {

    @FXML
    private ListView<VBoxCell> listviewUsers;
    
    private UserModel model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new UserModel();
        model.createUserList();
        model.setList(listviewUsers, true);
    }    

    @FXML
    private void handlePreviousButton(ActionEvent event) {
        model.setList(listviewUsers, true);
    }

    @FXML
    private void handleNextButton(ActionEvent event) {
        model.setList(listviewUsers, false);
    }
    
}
