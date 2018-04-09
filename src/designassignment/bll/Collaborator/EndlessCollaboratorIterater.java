/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.Collaborator;

import designassignment.be.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author janvanzetten
 */
public class EndlessCollaboratorIterater implements IteratorWithMultiNext<User>{
    
    List<User> collaborators;
    int currentIndex = 0;
 
    public EndlessCollaboratorIterater(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    @Override
    public List<User> next(int count) {
        int startIndex = currentIndex;
        boolean first = true;
        List<User> nextColabs = new ArrayList<>();
        while(currentIndex <= startIndex + count && (first||currentIndex == startIndex)){
            nextColabs.add(collaborators.get(currentIndex));
            
            first = false;
        }
        return nextColabs;
    }
    
    
    
}
