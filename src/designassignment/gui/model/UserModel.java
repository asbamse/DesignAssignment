/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.be.User;
import designassignment.bll.VBoxCell;
import javafx.scene.control.ListView;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;
import designassignment.dal.DALException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author alexl
 */
public class UserModel {
    
    private BLLFacade bll;
    private List<User> users;

    public UserModel()
    {
        this.bll = BLLManager.getInstance();
    }
    
    public void createUserList() {
        try {
            users = bll.getAllUsers();
        } catch (DALException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setList(ListView<VBoxCell> listviewUsers) {
        List<VBoxCell> tbl = new ArrayList<>();
        
        for (User user : users) {
            tbl.add(new VBoxCell(user));
        }
        
        ObservableList<VBoxCell> ol = FXCollections.observableArrayList();
        ol.addAll(tbl);
        listviewUsers.setItems(ol);
    }
    
}
