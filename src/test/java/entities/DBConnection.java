/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miguel
 */
public class DBConnection {
    
    private Connection con;
    
    public DBConnection() throws SQLException{
        this.con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mediaCenter?user=miguel");
    }
    
    public Connection getCon(){
        return this.con;
    }
}
