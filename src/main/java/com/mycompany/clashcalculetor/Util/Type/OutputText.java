/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.Type;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author mello
 */
public class OutputText extends OutputStream{
    JTextArea textArea;

    public OutputText() {
        this.textArea = new JTextArea();
    }
    @Override
    public void write(int i) throws IOException {
        textArea.append(Character.getName(i));
    }
    @Override
    public void write(byte[] bs){
        textArea.append(String.valueOf(bs));
    }
}
