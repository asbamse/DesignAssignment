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
public class EndlessCollaboratorIterater implements Iterator<User>{
    
    List<User> collaborators;
    int currentIndex;
 
    public EndlessCollaboratorIterater(List<User> collaborators) {
        this.collaborators = collaborators;
    }
    
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User next() {
        currentIndex++;
        
        
        if (currentIndex >= collaborators.size()){
            currentIndex = 0;
        }
        
        return collaborators.get(currentIndex);
        
    }
    
}
