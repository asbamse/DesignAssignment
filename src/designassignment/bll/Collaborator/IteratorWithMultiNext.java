/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.Collaborator;

import java.util.List;

/**
 *
 * @author janvanzetten
 */
public interface IteratorWithMultiNext<E>{
    
    public List<E> next(int count);
    
    
}
