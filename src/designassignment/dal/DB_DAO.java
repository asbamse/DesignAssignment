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
public class DB_DAO {

    DBConnecter connecter;

    public DB_DAO() {
        connecter = new DBConnecter();
    }

    List<Message> getAllMessages() throws DALException {
        try (Connection con = connecter.getConnection()) {
            String sql = "SELECT * FROM Message";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<Message> messages = new ArrayList<>();

            while (rs.next()) {

                Message message = new Message(rs.getString("Text"));

                messages.add(message);

            }

            return messages;

        } catch (SQLException ex) {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    Message saveNewMessage(String message) throws DALException {
        try (Connection con = connecter.getConnection()) {
            String sql = "INSERT INTO Message VALUES (?)";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(0, message);
            
            statement.execute();
            
            return new Message(message);

        } catch (SQLException ex) {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

}
