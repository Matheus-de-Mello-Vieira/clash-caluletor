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
public class InvalidChestException extends Exception{
    private static final long serialVersionUID = 1L;
    public String getText(){
        return "It chest is impossible at your chest sequence";
    } 
}
