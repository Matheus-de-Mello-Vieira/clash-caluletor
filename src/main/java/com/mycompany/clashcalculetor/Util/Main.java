/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util;

import com.mycompany.clashcalculetor.GUI.Login;
import com.mycompany.clashcalculetor.Service.ChestService;

/**
 *
 * @author mello
 */
public class Main {

    public static void main(String[] args) {
        //Open a session
        HibernateUtil.getSession();

        //Start the windowns
        Login login = new Login();
    }
    public static void afterLogin() {
        //Create a file, if it is the firt time
        (new ChestService()).createFile();
    }
}
