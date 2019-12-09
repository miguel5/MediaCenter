/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.DBConnection;
import entities.InvalidEmailPasswordException;
import entities.MediaCenter;
import entities.Utilizador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class Test {
    
    public static void main(String[] args) throws SQLException{
        
        
        Connection con = null;
        
        try {
            DBConnection dbcon = new DBConnection();
            con = dbcon.getCon();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //testeLogin(con);

    }
    
    private void teste1(Connection con) throws SQLException{
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Utilizador");
        
        int id = 0;
        String nome = "";
        String email = "";
        String password = "";
        int admin = 0;
        
        
        while (rs.next()) {
            id = rs.getInt("idUtilizador");
            nome = rs.getString("nome");
            email = rs.getString("email");
            password = rs.getString("password");
            admin = rs.getInt("admin");
        }
        
        System.out.println(id + "\n" + nome + "\n" + email + "\n" + password + "\n" + admin);
    }
    
    private static void testeRegistarUtilizador(Connection con) throws SQLException{
        MediaCenter mc = new MediaCenter(con);
        
        mc.registarUtilizador(new Utilizador("Mini", "mini@gmail.com", "12345", 0, false, null, null));
    }
    
    private static void testeRemoverUtilizador(Connection con) throws SQLException{
        MediaCenter mc = new MediaCenter(con);
        
        mc.removerUtilizador(3);
    }
    
    private static void testeCriarPlaylist(Connection con) throws SQLException{
        MediaCenter mc = new MediaCenter(con);
        
        mc.criarPlaylist("RapCaviar", 1);
    }
    
    private static void testeLogin(Connection con) throws SQLException, InvalidEmailPasswordException{
        MediaCenter mc = new MediaCenter(con);
        
        int id = mc.login("mike@gmail.com", "12345");
        
        System.out.println(id);
    }
    
    private static void testeLoginGUI(Connection con){
        
    }
}
