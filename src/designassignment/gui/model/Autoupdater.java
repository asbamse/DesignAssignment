/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model;

import designassignment.bll.ChangeChecker;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author janvanzetten
 */
public class Autoupdater implements Observer{
    
    MainModel model;

    public Autoupdater(MainModel model) {
        this.model = model;
    }
    
    public void setAsObserver(){
        new ChangeChecker().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updates...in autoupdate line 30");
        model.getAllMessages();
    }
    
    
    
    
}
