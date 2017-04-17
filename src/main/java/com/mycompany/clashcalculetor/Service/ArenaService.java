/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Service;

import com.mycompany.clashcalculetor.Dao.ArenaDao;
import com.mycompany.clashcalculetor.Models.Arena;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Util.Exception.InvalidArenaException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mello
 */
public class ArenaService {

    ArenaDao arenaDao;

    public ArenaService() {
        this.arenaDao = new ArenaDao();
    }

    public Arena findBy(short idArena) {
        return arenaDao.findBy(idArena);
    }

    public Arena findBy(String name) {
        return arenaDao.findBy(name);
    }

    public Arena findBy(Integer trophy) {
        return arenaDao.findBy(trophy);
    }

    public List<Arena> listAll() {
        return arenaDao.listAll();
    }

    public void upArena(Client client) {
        try {
            if (ClientService.getCurrentClient().getIdArena().getIdArena() == 20) {
                throw new InvalidArenaException("It's impossible");
            }

            ClientService.getCurrentClient().setIdArena(
                    findBy(
                            Short.parseShort(
                                    String.valueOf(
                                            ClientService
                                                    .getCurrentClient()
                                                    .getIdArena()
                                                    .getIdArena() + 1))));
            new ClientService().update(client);
        } catch (InvalidArenaException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void downArena(Client client) {
        try {
            if (ClientService.getCurrentClient().getIdArena().getIdArena() == 1) {
                throw new InvalidArenaException("It's impossible");
            }
            ClientService.getCurrentClient().setIdArena(
                    findBy(
                            Short.parseShort(
                                    String.valueOf(
                                            ClientService
                                                    .getCurrentClient()
                                                    .getIdArena()
                                                    .getIdArena() - 1))));
            new ClientService().update(client);
        } catch (InvalidArenaException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
