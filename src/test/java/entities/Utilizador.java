/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class Utilizador {
    
    private String nome;
    private String email;
    private String password;
    private int id;
    private boolean admin;
    private List<Integer> amigos;
    private List<Integer> playlists;
    
    
    public Utilizador(String nome, String email, String password, int id, boolean admin, List<Integer> amigos, List<Integer> playlists) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.id = id;
        this.admin = admin;
        this.amigos = amigos;
        this.playlists = playlists;
    }
    
    public Utilizador(){
        this.nome = "";
        this.email = "";
        this.password = "";
        this.id = 0;
        this.admin = false;
        this.amigos = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Integer> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Integer> amigos) {
        this.amigos = amigos;
    }

    public List<Integer> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Integer> playlists) {
        this.playlists = playlists;
    }
    
    
    // ------------
    
    public void changePassword(String oldPW, String newPW) throws WrongPasswordException {
        
        if(oldPW.equals(this.password))
            this.setPassword(newPW);
        else
            throw new WrongPasswordException();
    }
    
    public void addPlaylist(int id) throws PlaylistAlreadyAddedException {
        if(this.playlists.contains(id))
            throw new PlaylistAlreadyAddedException();
        else
            this.playlists.add(id);
    }
    
    public void removePlaylist(int id) throws PlaylistNotFoundException {
        if(this.playlists.contains(id))
            this.playlists.remove((Object) id);
        else
            throw new PlaylistNotFoundException();
    }
    
    public void addFriend(int id) throws FriendAlreadyAddedException {
        if(this.amigos.contains(id))
            throw new FriendAlreadyAddedException();
        else
            this.amigos.add(id);
    }
    
    public void removeFriend(int id) throws FriendNotFoundException {
        if(this.amigos.contains(id))
            this.amigos.remove((Object) id);
        else
            throw new FriendNotFoundException();
    }
    
}
