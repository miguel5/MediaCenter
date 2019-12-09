/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author miguel
 */
public class MediaCenter {
    
    private static Connection con;
    private int idLoggedIn;        // id do utilizador com sessão iniciada (convidado = 0)
    
    public MediaCenter(Connection con) throws SQLException{
        this.con = con;
        this.idLoggedIn = 0;
    }
    
    
    public void registarUtilizador(Utilizador u) throws SQLException {
        String query = "INSERT INTO Utilizador (nome, email, password, admin)"
                + "VALUES (?, ?, ?, ?)";
        
        int admin = 0;
        if(u.isAdmin())
            admin = 1;
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getPassword());
        ps.setInt(4, admin);
        ps.execute();
    }
    
    public void removerUtilizador(int id) throws SQLException{
        String query = "DELETE FROM Utilizador WHERE idUtilizador = " + id;
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.execute();
    }
    
    public void criarPlaylist(String nome, int userId) throws SQLException{
        String query = "INSERT INTO Playlist (nome, Utilizador_idUtilizador)"
                + "VALUES (?, ?)";
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, nome);
        ps.setInt(2, userId);
        ps.execute();
    }
    
    public void removerPlaylist(int id) throws SQLException{
        String query = "DELETE FROM Playlist WHERE idPlaylist = " + id;
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.execute();
    }
    
    // Retorna o id do utilizador caso as creenciais sejam  validas, caso contrario retorna 0
    // coloca o valor devolvido em this.idLoggedIn
    public int login(String email, String password) throws SQLException, InvalidEmailPasswordException{
        String query = "SELECT * FROM Utilizador WHERE email = ? AND password = ? ";
        int id = 0;
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            if(rs.wasNull())
                throw new InvalidEmailPasswordException();
            else{
                id = rs.getInt("idUtilizador");
            }
        }
        
        this.idLoggedIn = id;
        return id;
    }
}
