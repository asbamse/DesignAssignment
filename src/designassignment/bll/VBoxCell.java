/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.User;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author alexl
 */
public class VBoxCell extends VBox {
    
    private User user;
    
    public VBoxCell(User user) {
        super();

        Label lblid = new Label();
        Label lblname = new Label();
        this.user = user;

        lblid.setText(user.getId() + "");
        lblname.setText(user.getName());
        
        this.getChildren().addAll(lblid, lblname);

    }
}
