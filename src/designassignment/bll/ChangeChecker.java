/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.Message;
import designassignment.dal.DALException;
import designassignment.dal.DBChangeDAO;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author janvanzetten
 */
public class ChangeChecker extends Observable {

    private DBChangeDAO DBDAO;
    private int lastMessageId;
    private static Thread thread;
    private static boolean running = true;

    private final static long WAIT_TIME = 1000;

    public ChangeChecker() {
        DBDAO = new DBChangeDAO();

        try {
            lastMessageId = DBDAO.getNewstMessage();
        } catch (DALException ex) {
            Logger.getLogger(ChangeChecker.class.getName()).log(Level.SEVERE, null, ex);
        }

        thread = new Thread(getTask(Thread.currentThread()));

        thread.start();
    }

    private Runnable getTask(Thread fxThread) {
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                while (running) {
                    int messagesId = DBDAO.getNewstMessage();
                    System.out.println(messagesId);
                    if (messagesId != lastMessageId) {
                        //if the last message is not the same:
                        setChanged();
                        Platform.runLater(() -> {
                            notifyObservers();
                        });
                                
                        lastMessageId = messagesId;
                        

                    }
                    
                    Thread.sleep(WAIT_TIME);
                }
                return null;
            }
        };
        return task;
    }
    
    public static void stopTask(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ChangeChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
