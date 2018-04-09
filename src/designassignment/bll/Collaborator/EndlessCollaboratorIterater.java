/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.Collaborator;

import designassignment.be.User;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author janvanzetten
 */
public class EndlessCollaboratorIterater implements Iterator{

    public EndlessCollaboratorIterater(List<User> collaborators) {
        
    }
    
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
