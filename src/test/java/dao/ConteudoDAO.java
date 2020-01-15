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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class ConteudoDAO {
    
    private static Connection con;
    private Utilizador user;
    private ArrayList<Conteudo> searchResults;
    
    
    public ConteudoDAO(Connection con) throws SQLException{
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
    
    
    public void uploadConteudo(Conteudo c) throws SQLException{
        String query = "INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, c.getTitulo());
        ps.setString(2, c.getPath());
        ps.setString(3, c.getArtista());
        ps.setString(4, c.getGenero());
        ps.setInt(5, c.getTipo());
        ps.execute();
    }
    
    public void alterarGenero(int id, String genero) throws SQLException{
        String query = "UPDATE Conteudo SET genero = ? WHERE idConteudo = ?";
        
        PreparedStatement ps = this.con.prepareStatement(query);
        ps.setString(1, genero);
        ps.setInt(2, id);
        ps.execute();
    }
}
