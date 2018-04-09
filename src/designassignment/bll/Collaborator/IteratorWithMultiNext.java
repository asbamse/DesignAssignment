/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.Collaborator;

import designassignment.bll.BLLException;
import java.util.List;

/**
 *
 * @author janvanzetten
 */
public interface IteratorWithMultiNext<E>{
    
    
    /**
     * get the next bunch of collaborators
     * @param count the amount of collaborators
     * @return
     * @throws BLLException 
     */
    public List<E> next(int count) throws BLLException;
    
    public List<E> previous(int count) throws BLLException;
}
