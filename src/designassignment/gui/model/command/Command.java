/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model.command;

import designassignment.bll.CommandException;

/**
 *
 * @author janvanzetten
 */
public interface Command
{

    public void execute() throws CommandException;

    public void undo() throws CommandException;

}
