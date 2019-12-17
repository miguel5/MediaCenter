/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Conteudo;
import entities.DBConnection;
import entities.InvalidEmailPasswordException;
import entities.MediaCenter;
import entities.Utilizador;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
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
    
    public Utilizador getUtilzador(){
        return this.mc.getUser();
    }
    
    public boolean login(String email, String password) throws SQLException, InvalidEmailPasswordException{
        int id = mc.login(email, password);
        if(id != 0)
            return true;
        else
            return false;
    }
    
    public void logout(){
        this.mc.logout();
    }
    
    
    public void fetchContent(String tag) throws SQLException{
        this.mc.fetchContent(tag);
    }
    
    public ListModel getSearchListModel(){
        return this.mc.getSearchListModel();
    }
    
    public Conteudo searchResultsGet(int index){
        return this.mc.searchResultsGet(index);
    }
    
    public void registarUtilizador(String nome, String email, String password) throws SQLException{
        Utilizador u = new Utilizador();
        u.setNome(nome);
        u.setEmail(email);
        u.setPassword(password);
        this.mc.registarUtilizador(u);
    }
    
    public boolean isAdmin(){
        return this.mc.isAdmin();
    }
    
}
