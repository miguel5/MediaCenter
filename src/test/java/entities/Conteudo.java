/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author miguel
 */
public class Conteudo {
    
    private int id;
    private String titulo;
    private String artista;
    private String genero;
    private String categoria;
    private String path;
    private List<Integer> owners;
    

    public Conteudo(int id, String titulo, String artista, String genero, String categoria, String path, List<Integer> owners) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.categoria = categoria;
        this.path = path;
        this.owners = owners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Integer> getOwners() {
        return owners;
    }

    public void setOwners(List<Integer> owners) {
        this.owners = owners;
    }
    
    // Pode ter que ser alterada futuramente!!
    public boolean equals(Conteudo c){
        
        if(this == c)
            return true;
        
        if(c == null)
            return false;
        
        return (this.artista.equals(c.artista) && this.titulo.equals(c.titulo));
    }
    
    // --------------
    
    public void addOwner(int id) throws UserAlreadyOwnsException {
        if(this.owners.contains(id))
            throw new UserAlreadyOwnsException();
        else
            this.owners.add(id);
    }
    
    public void removeOwner(int id) throws UserNotFoundException {
        if(this.owners.contains(id))
            this.owners.remove((Object) id);
        else
            throw new UserNotFoundException();
    }
}
