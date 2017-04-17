/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.Exception;

/**
 *
 * @author mello
 */
public class PasswordDontMachException extends Exception{
    private String err;
    public PasswordDontMachException(){
        err="Password dont match";
    }

    /**
     * @return the err
     */
    public String getErr() {
        return "Error "+err;
    }
}
