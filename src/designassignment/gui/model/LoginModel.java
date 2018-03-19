/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.bll.BLLException;
import designassignment.bll.BLLManager;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author alexl
 */
public class LoginModel {

    private BLLManager bll;

    public LoginModel() {
        bll = BLLManager.getInstance();
    }

    public void createUser(String username, String password, String email) {
        try {
            bll.createUser(username, email, password);
        } catch (BLLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

}
