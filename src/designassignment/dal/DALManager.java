/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import designassignment.be.User;
import java.util.List;

/**
 *
 * @author Asbamz
 */
public class DALManager implements DALFacade
{
    DAO dbdao = new DB_DAO();
    
    User currentUser;

    private static DALManager instance;

    /**
     * Singleton method.
     * @return
     */
    public static DALManager getInstance()
    {
        if (instance == null)
        {
            instance = new DALManager();
        }
        return instance;
    }

    /**
     * Constructor.
     */
    private DALManager()
    {
    }

    /**
     * Send message.
     * @param message
     * @return
     */
    @Override
    public Message sendMessage(String message) throws DALException
    {
        if (currentUser == null){
            throw new DALException("Please login before sending messages");
        }
        return dbdao.saveNewMessage(message, currentUser);
    }

    /**
     * Get message.
     * @return
     * @throws DALException
     */
    @Override
    public List<Message> getMessages() throws DALException
    {
        return dbdao.getAllMessages();
    }

    @Override
    public void deleteMessage(Message thisMessage) throws DALException {
        dbdao.deleteMessage(thisMessage);
    }

    @Override
    public User addUser(String name, String Email, String password) throws DALException {
        currentUser = dbdao.addUser(name,Email,password);
        return currentUser;
    }

    @Override
    public User userLogin(String username, String password) throws DALException {
        currentUser = dbdao.login(username,password);
        return currentUser;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
    
    @Override
    public List<User> getAllUsers() throws DALException {
        return dbdao.getAllUsers();
    }

}
