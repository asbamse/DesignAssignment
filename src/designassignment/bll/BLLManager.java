/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll;

import designassignment.be.Message;
import designassignment.dal.DALException;
import designassignment.dal.DALFacade;
import designassignment.dal.DALManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asbamz
 */
public class BLLManager implements BLLFacade {

    private static BLLManager INSTANCE = null;
    private DALFacade dal;

    /**
     * BLLManager constructor.
     */
    private BLLManager() {
        this.dal = DALManager.getInstance();
    }

    public static BLLManager getInstance() {
        if (INSTANCE == null) {
            synchronized (BLLManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BLLManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Send message.
     *
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message) throws BLLException {
        try {
            return dal.sendMessage(message);
        } catch (DALException ex) {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public List<Message> getMessages() throws BLLException {
        try {
            return dal.getMessages();
        } catch (DALException ex) {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void deleteMessage(Message thisMessage) throws BLLException {
        try {
            dal.deleteMessage(thisMessage);
        } catch (DALException ex) {
            throw new BLLException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void createUser(String username, String email, String password) throws BLLException {
        try {

            String encryptedPassword = encrypt(password);
            
            try {
                dal.addUser(email, email, encryptedPassword);
            } catch (DALException ex) {
                throw new BLLException(ex.getMessage(), ex.getCause());
            }
        } 
        catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(BLLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login(String username, String password) throws BLLException {
        try {
            
            dal.userLogin(username, encrypt(password));
            
        } catch (DALException ex) {
            throw new BLLException(ex.getMessage(), ex.getCause());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(BLLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String encrypt(String base) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            
            StringBuffer hexString = new StringBuffer();
            
            for (int i = 0; i < hash.length; i++) {
                
                String hex = Integer.toHexString(0xff & hash[i]);
                
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                
                hexString.append(hex);
            }
            
            return hexString.toString();
    }

}
