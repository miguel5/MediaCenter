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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author miguel
 */
public class MediaCenter {
    
    private static Connection con;
    private int idLoggedIn;        // id do utilizador com sessão iniciada (convidado = 0)
    private Utilizador user;
    private ArrayList<Conteudo> searchResults;
    
    public MediaCenter(Connection con) throws SQLException{
        this.con = con;
        this.idLoggedIn = 0;
        this.user = new Utilizador();
        this.searchResults = new ArrayList<>();
    }

    public Utilizador getUser() {
        return user;
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
                this.user.setId(id);
                this.user.setNome(rs.getString("nome"));
                this.user.setEmail(rs.getString("email"));
                this.user.setPassword(rs.getString("password"));
                this.user.setNome(rs.getString("nome"));
                if(rs.getInt("admin") == 1)
                    this.user.setAdmin(true);
            }
        }
        
        this.idLoggedIn = id;
        return id;
    }
    
    public void logout(){
        this.idLoggedIn = 0;
        this.user = new Utilizador();
    }
    
    
    public void fetchContent(String tag) throws SQLException{
        ArrayList<Conteudo> results = new ArrayList<>();
        // procura por substrings
        String query = "SELECT * FROM Conteudo WHERE INSTR(titulo, ?) > 0 OR "
                + "INSTR(artista, ?) > 0 OR "
                + "INSTR(genero, ?) > 0";
                
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, tag);
        ps.setString(2, tag);
        ps.setString(3, tag);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("idConteudo");
            String titulo = rs.getString("titulo");
            String path = rs.getString("localizacao");
            String artista = rs.getString("artista");
            String genero = rs.getString("genero");
            int tipo = rs.getInt("tipo");
            Conteudo c = new Conteudo(id, titulo, artista, genero, path, tipo);
            results.add(c);
        }
        
        this.searchResults = results;
    }
    
    public Conteudo searchResultsGet(int index){
        return this.searchResults.get(index);
    }
    
    
    // Devolve um ListModel com os resultados atuais de uma procura
    public ListModel getSearchListModel(){
        DefaultListModel dlm = new DefaultListModel();
        
        this.searchResults.forEach((c) -> {
            dlm.addElement(c.toString());
        });
        
        return dlm;
    }
    
    public boolean isAdmin(){
        return this.user.isAdmin();
    }
}
