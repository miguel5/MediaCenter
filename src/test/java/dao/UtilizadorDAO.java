/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Conteudo;
import entities.InvalidEmailPasswordException;
import entities.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class UtilizadorDAO {
    
    private static Connection con;
    private Utilizador user;
    private ArrayList<Conteudo> searchResults;
    
    
    public UtilizadorDAO(Connection con) throws SQLException{
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
                this.user.setId(id);
                this.user.setNome(rs.getString("nome"));
                this.user.setEmail(rs.getString("email"));
                this.user.setPassword(rs.getString("password"));
                this.user.setNome(rs.getString("nome"));
                if(rs.getInt("admin") == 1)
                    this.user.setAdmin(true);
            }
        }
        
        return id;
    }
    
    // Checks if the given email is already registered in the database (returns true if email is already in the db)
    public boolean hasEmail(String email) throws SQLException{
        String query = "SELECT * FROM Utilizadores WHERE email = " + email;
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        if(rs.wasNull())
            return false;
        else
            return true;
    }
}
