/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.be.Message;

/**
 *
 * @author Asbamz
 */
public class MainModel
{
    public Message sendMessage(String message)
    {
        return new Message(message);
    }
}
