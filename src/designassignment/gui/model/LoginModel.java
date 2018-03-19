/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.bll.BLLException;
import designassignment.bll.BLLFacade;
import designassignment.bll.BLLManager;

/**
 *
 * @author alexl
 */
public class LoginModel {
    
    private BLLManager bll;
    
    public LoginModel() {
        bll = BLLManager.getInstance();
    }

    public void createUser(String username, String password, String email) throws BLLException {
        bll.createUser(username, email, password);
    }
    
    
}
