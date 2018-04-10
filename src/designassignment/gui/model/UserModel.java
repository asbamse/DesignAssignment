/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.be.User;
import designassignment.bll.BLLException;
import designassignment.bll.VBoxCell;
import javafx.scene.control.ListView;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;
import designassignment.dal.DALException;
import designassignment.bll.Collaborator.EndlessCollaboratorIterater;
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
    private List<VBoxCell> tbl;
    private EndlessCollaboratorIterater iter;
    private ObservableList<VBoxCell> ol = FXCollections.observableArrayList();

    public UserModel() {
        this.bll = BLLManager.getInstance();
    }

    public void createUserList() {
        try {
            iter = new EndlessCollaboratorIterater(bll.getAllUsers());
        } catch (DALException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setList(ListView<VBoxCell> listviewUsers, boolean nextOrPrevious) {
        try {
            tbl.clear();
            ol.clear();
            tbl = new ArrayList<>();

            if (nextOrPrevious == true) {
                for (User user : iter.next(5)) {
                    tbl.add(new VBoxCell(user));
                }
            }
            else {
                for (User user : iter.previous(5)) {
                    tbl.add(new VBoxCell(user));
                }
            }
            
            ol.addAll(tbl);
            listviewUsers.setItems(ol);
        } catch (BLLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
