/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.DBConnection;
import entities.InvalidEmailPasswordException;
import entities.MediaCenter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tests.Test;

/**
 *
 * @author miguel
 */
public class UIFacade {
    
    private MediaCenter mc;
    
    public UIFacade() throws SQLException{
        
        Connection con = null;
        
        try {
            DBConnection dbcon = new DBConnection();
            con = dbcon.getCon();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.mc = new MediaCenter(con);
    }
    
    public boolean login(String email, String password) throws SQLException, InvalidEmailPasswordException{
        int id = mc.login(email, password);
        if(id != 0)
            return true;
        return false;
    }
}
