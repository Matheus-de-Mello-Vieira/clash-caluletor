package com.mycompany.clashcalculetor.Service;

import com.mycompany.clashcalculetor.Dao.ChestDao;
import com.mycompany.clashcalculetor.Dao.ClientDao;
import com.mycompany.clashcalculetor.Models.Client;

public class ClientService {
    private ClientDao clientDao;
    private static Client currentClient;
    public ClientService(){
        clientDao=new ClientDao();
    }
    public void update(Client client){
       clientDao.update(client);
    }
    public void singUp(Client client) {
        client.setIdCurrentChest(new ChestDao().findById(243));
        clientDao.singUp(client);
        currentClient=client;
    }

    public boolean singIn(String user, String password) {
        if(clientDao.singIn(user, password)){
            currentClient=clientDao.findBy(user);
            return true;
        }
        return false;
    }

    /**
     * @return the currentClient
     */
    public static Client getCurrentClient() {
        return currentClient;
    }
}
