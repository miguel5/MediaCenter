/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miguel
 */
public class Biblioteca {
    
    private Map<Integer,Conteudo> colecao;
    private int contentIdCounter;
    
    public Biblioteca(){
        this.colecao = new HashMap<>();
        this.contentIdCounter = 0;
    }
    
    //----------------
    
    public Conteudo getConteudo(int id) throws ContentNotFoundException {
        
        if(this.colecao.containsKey(id))
            return this.colecao.get(id);
        else
            throw new ContentNotFoundException();
    }
    
    public void addConteudo(Conteudo c) throws ContentAlreadyAddedException {
        
        if(this.isDuplicate(c))
            throw new ContentAlreadyAddedException();
        else{
            this.colecao.put(this.contentIdCounter, c);
            this.contentIdCounter++;
        }   
    }
    
    public void removeConteudo(int id){
        this.colecao.remove(id);
    }
    
    private boolean isDuplicate(Conteudo c){
        
        for(Map.Entry<Integer,Conteudo> entry : this.colecao.entrySet()){
            if(c.equals(entry.getValue()))
                return true;
        }
        
        return false;
    }
    
}