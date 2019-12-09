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
public class UserAlreadyOwnsException extends Exception {
    
    public UserAlreadyOwnsException(){
        super("User is already an owner of this content!");
    }
}
