/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import designassignment.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janvanzetten
 */
public class DB_DAO implements DAO
{

    DBConnecter connecter;

    public DB_DAO()
    {
        connecter = new DBConnecter();
    }

    /**
     * get all the messages from the database
     *
     * @return
     * @throws DALException
     */
    @Override
    public List<Message> getAllMessages() throws DALException
    {
        try (Connection con = connecter.getConnection())
        {
            String sql = "SELECT * FROM Message";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<Message> messages = new ArrayList<>();

            while (rs.next())
            {

                Message message = new Message(rs.getInt("Id"), rs.getString("Text"), rs.getInt("UserId"));

                messages.add(message);

            }

            return messages;

        }
        catch (SQLException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    /**
     * add a new message to the database
     *
     * @param message
     * @param sender the user who made the message
     * @return if there is no exeption it will return a new message object with
     * the given text
     * @throws DALException
     */
    @Override
    public Message saveNewMessage(String message, User sender) throws DALException
    {
        try (Connection con = connecter.getConnection())
        {
            String sql = "INSERT INTO Message VALUES (?), (?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, message);
            statement.setInt(2, sender.getId());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return new Message(id, message, sender.getId());
        }
        catch (SQLException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    public void deleteMessage(Message thisMessage) throws DALException
    {
        try (Connection con = connecter.getConnection())
        {
            String sql = "DELETE Message WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, thisMessage.getId());

            statement.execute();

        }
        catch (SQLException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public User addUser(String name, String email, String password) throws DALException {
        try (Connection con = connecter.getConnection())
        {
            String sql = "INSERT INTO [User] VALUES( ?, ?, ?);";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return new User(id, name, email, password);
        }
        catch (SQLException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public User login(String username, String password) throws DALException {
        try (Connection con = connecter.getConnection())
        {
            String sql = "SELECT * FROM [User] WHERE Name = ? AND Password = ?";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, username);
            statement.setString(2, password);


            ResultSet rs = statement.executeQuery();
            if (!rs.next()){
                throw new DALException("The username or password is ivalid, create user if you do not have one.");
            }
            int id = rs.getInt(1);
            String email = rs.getString(3);

            return new User(id, username, email, password);
        }
        catch (SQLException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

}
