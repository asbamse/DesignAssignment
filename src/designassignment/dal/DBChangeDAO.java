/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author janvanzetten
 */
public class DBChangeDAO {
    
    DBConnecter connecter;

    public DBChangeDAO() {
        connecter = new DBConnecter();
    }
    
    

    public int getNewstMessage() throws DALException {
        try(Connection con = connecter.getConnection()){
             String sql = "SELECT max(Id) FROM Message;";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rs.next();
            
            return rs.getInt(1);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }
    
    
    
}
