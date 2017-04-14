/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.Type;

/**
 *
 * @author mello
 */
public class CartQuant {
    private byte quant;
    private String name;
    
    public CartQuant(byte quant,String name){
        this.quant=quant;
        this.name=name;
    }

    /**
     * @return the quant
     */
    public byte getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(byte quant) {
        this.quant = quant;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
