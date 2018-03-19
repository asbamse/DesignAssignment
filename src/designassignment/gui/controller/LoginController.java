/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import designassignment.bll.BLLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import designassignment.gui.model.LoginModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author alexl
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtfieldUsername;
    @FXML
    private TextField txtfieldPassword;
    @FXML
    private Label lblEMail;
    @FXML
    private TextField txtfieldEMail;
    
    private LoginModel model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new LoginModel();
        lblEMail.setVisible(false);
        txtfieldEMail.setVisible(false);
        txtfieldEMail.setDisable(true);
    }

    @FXML
    private void handleSignIn(ActionEvent event) {
        
        model.login(txtfieldUsername.getText(), txtfieldPassword);
        

    }

    @FXML
    private void handleNewUser(ActionEvent event) {
        if (txtfieldEMail.getText().isEmpty()) {
            lblEMail.setVisible(true);
            txtfieldEMail.setVisible(true);
            txtfieldEMail.setDisable(false);
        }
        else if (!txtfieldUsername.getText().isEmpty() 
                && !txtfieldPassword.getText().isEmpty() 
                && !txtfieldEMail.getText().isEmpty()){
            model.createUser(txtfieldUsername.getText(), txtfieldPassword.getText(), txtfieldEMail.getText());
        }
    }

}
