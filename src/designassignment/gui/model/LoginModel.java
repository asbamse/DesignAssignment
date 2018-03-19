/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.bll.BLLException;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author alexl
 */
public class LoginModel {

    private BLLFacade bll;

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

    public void login(String username, TextField password) {
        try {
            
            bll.login(username, password.getText());
            
            Parent root = FXMLLoader.load(getClass().getResource("/designassignment/gui/view/MainView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) password.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("CHat");
            
            
            
        } catch (BLLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
