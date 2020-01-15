/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Conteudo;
import entities.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class PlaylistDAO {
    
    private static Connection con;
    private Utilizador user;
    private ArrayList<Conteudo> searchResults;
    
    
    public PlaylistDAO(Connection con) throws SQLException{
        this.con = con;
        this.user = new Utilizador();
        this.searchResults = new ArrayList<>();
    }
    
    public List<Conteudo> getSearchResults(){
        return this.searchResults;
    }
    
    public Utilizador getUtilizador(){
        return this.user;
    }
    
    
    public void criarPlaylist(String nome, int userId) throws SQLException{
        String query = "INSERT INTO Playlist (nome, Utilizador_idUtilizador)"
                + "VALUES (?, ?)";
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, nome);
        ps.setInt(2, userId);
        ps.execute();
    }
}
