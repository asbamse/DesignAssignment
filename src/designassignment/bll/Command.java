/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

/**
 *
 * @author janvanzetten
 */
public interface Command {
    
    public void execute();
    
    public void undo();
    
}
