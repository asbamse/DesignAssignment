/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.bll.BLLException;

/**
 *
 * @author janvanzetten
 */
public interface Command {
    
     
    
    public void execute() throws BLLException;
    
    public void undo();
    
}
