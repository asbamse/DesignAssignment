/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
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

                Message message = new Message(rs.getString("Text"));

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
     * @return if there is no exeption it will return a new message object with
     * the given text
     * @throws DALException
     */
    @Override
    public Message saveNewMessage(String message) throws DALException
    {
        try (Connection con = connecter.getConnection())
        {
            String sql = "INSERT INTO Message VALUES (?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, message);

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return new Message(message, id);

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

}
