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
public class Playlist {
    
    private int id;
    private List<Integer> contentList;
    private int criador;
    private String nome;

    public Playlist(int id, List<Integer> contentList, int criador, String nome) {
        this.id = id;
        this.contentList = contentList;
        this.criador = criador;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getContentList() {
        return contentList;
    }

    public void setContentList(List<Integer> contentList) {
        this.contentList = contentList;
    }

    public int getCriador() {
        return criador;
    }

    public void setCriador(int criador) {
        this.criador = criador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // ----------------
    
    public void addContent(int id) throws ContentAlreadyAddedException {
        if(this.contentList.contains(id))
            throw new ContentAlreadyAddedException();
        else
            this.contentList.add(id);
    }
    
    public void removeContent(int id) throws ContentNotFoundException {
        if(this.contentList.contains(id))
            this.contentList.remove((Object) id);
        else
            throw new ContentNotFoundException();
    }
    
}
