/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author miguel
 */
public class PlaylistNotFoundException extends Exception {
    
    public PlaylistNotFoundException(){
        super("Playlist not found!");
    }
}
