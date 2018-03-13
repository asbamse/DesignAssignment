/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblEMail.setVisible(false);
        txtfieldEMail.setVisible(false);
    }

    @FXML
    private void handleSignIn(ActionEvent event) {

    }

    @FXML
    private void handleNewUser(ActionEvent event) {
        if (txtfieldEMail.getText().isEmpty()) {
            lblEMail.setVisible(true);
            txtfieldEMail.setVisible(true);
        }
        else {
            
        }
    }

}
