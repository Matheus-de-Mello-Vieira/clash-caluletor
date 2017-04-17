/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.Exception;

/**
 *
 * @author melloInvalidArenaException
 */
public class InvalidArenaException extends Exception{

    private static final long serialVersionUID = 1L;
    private String message;
    public InvalidArenaException(String message) {
        this.message="Error"+message;
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
        return message;
    }
    
}
