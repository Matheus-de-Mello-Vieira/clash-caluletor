package com.mycompany.clashcalculetor.Service;

import com.mycompany.clashcalculetor.Dao.ChestDao;
import com.mycompany.clashcalculetor.Files.ChestFile;
import com.mycompany.clashcalculetor.Models.Chest;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Util.Exception.InvalidChestException;
import com.mycompany.clashcalculetor.Util.Type.NextChest;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChestService {

    private ChestDao chestDao;
    private ChestFile chestFile;
    private boolean chestIsDataBase;

    public ChestService(Client client) {
        chestDao = new ChestDao();
        chestFile = new ChestFile();
        chestIsDataBase = client.getIdCurrentChest().getIdChest() != 243;
    }

    public ChestService() {
        this(ClientService.getCurrentClient());
    }

    public List<Chest> listAll() {
        return chestDao.listAll();
    }

    public String[] listAllString() {
        String[] result = new String[chestDao.listAll().size()];
        for (int i = 0; i < chestDao.listAll().size(); i++) {
            result[i] = chestDao.listAll().get(i).getName();
        }
        return result;
    }

    public void resetFile() {
        chestFile.deleteFile();
        createFile();
    }

    public boolean nextChest(String chest) {
        if (chestIsDataBase) {
            if (ClientService.getCurrentClient().getIdCurrentChest().getIdChest() == 240) {
                ClientService.getCurrentClient().getIdCurrentChest().setIdChest(0);
            }
            ClientService
                    .getCurrentClient()
                    .getIdCurrentChest()
                    .setIdChest(
                            ClientService
                                    .getCurrentClient()
                                    .getIdCurrentChest().getIdChest() + 1);
            new ClientService().update(ClientService.getCurrentClient());

            return true;
        }
        try {
            Integer[] result = chestFile.read();
            ArrayList<Chest> possibleChest = new ArrayList<>();
            for (int idChest : result) {

                try {
                    if (chestDao.findById(idChest).getName().equalsIgnoreCase(chest)) {
                        if (idChest == 240) {
                            idChest = 0;
                        }
                        idChest++;
                        possibleChest.add(chestDao.findById(idChest));
                    }
                    if (possibleChest.isEmpty()) {
                        throw new InvalidChestException();
                    } else if (possibleChest.size() == 1) {
                        ClientService
                                .getCurrentClient()
                                .getIdCurrentChest()
                                .setIdChest(possibleChest.get(0).getIdChest());
                        new ClientService().update(ClientService.getCurrentClient());
                        chestIsDataBase = true;
                    } else {
                        chestFile.writeListc(possibleChest);
                    }

                } catch (InvalidChestException e) {
                    JOptionPane.showMessageDialog(null, e.getText());
                    return false;
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Erro, null in nextChest(String)");

                } catch (Exception e) {
                    System.out.println(idChest + "\n");
                }

            }

        } catch (NullPointerException e) {
            resetFile();
        } catch (Exception ex) {
            Logger.getLogger(ChestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void createFile() {
        try {
            File file = new File("chest.txt");
            if (!file.exists()) {
                chestFile.createFile();
                chestFile.writeListc(chestDao.listAll().subList(0, 240));

            }
        } catch (Exception ex) {
            Logger.getLogger(ChestService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nextChest() {
        if (chestIsDataBase) {
            if (ClientService.getCurrentClient().getIdCurrentChest().getIdChest() == 240) {
                ClientService.getCurrentClient().getIdCurrentChest().setIdChest(0);
            }
            ClientService
                    .getCurrentClient()
                    .getIdCurrentChest()
                    .setIdChest(
                            ClientService
                                    .getCurrentClient()
                                    .getIdCurrentChest().getIdChest() + 1);
            new ClientService().update(ClientService.getCurrentClient());
            return;
        }
        try {
            Integer[] results = chestFile.read();
            for (int i = 0; i < results.length; i++) {
                if (results[i] == 240) {
                    results[i] = 0;
                }
                if (results[i] > 240) {
                    JOptionPane.showMessageDialog(null, "erro nextChest()");
                }
                results[i]++;
            }
            if (results.length == 1) {
                ClientService
                        .getCurrentClient()
                        .getIdCurrentChest()
                        .setIdChest(results[0]);
                new ClientService().update(ClientService.getCurrentClient());
                chestIsDataBase = true;
            } else {
               chestFile.writeList(Arrays.asList(results));
            }
        } catch (NullPointerException e) {
            resetFile();
        } catch (Exception e) {

        }
    }

    public NextChest calculetorNextChest() {
        if (chestIsDataBase) {
            NextChest nextChest = new NextChest();
            switch (ClientService.getCurrentClient().getIdCurrentChest().getName()) {
                case "Silver":
                    nextChest.setPorcentSilver(nextChest.getPorcentSilver() + 1);
                    break;
                case "Gold":
                    nextChest.setPorcentGold(nextChest.getPorcentGold() + 1);
                    break;
                case "Magic":
                    nextChest.setPorcentMagic(nextChest.getPorcentMagic() + 1);
                    break;
                case "Gigan":
                    nextChest.setPorcentGigant(nextChest.getPorcentGigant() + 1);
                    break;
            }
            return nextChest;
        }
        try {
            NextChest result = new NextChest();
            for (int index : chestFile.read()) {
                switch (chestDao.findById(index).getName()) {
                    case "Silver":
                        result.setPorcentSilver(result.getPorcentSilver() + 1);
                        break;
                    case "Gold":
                        result.setPorcentGold(result.getPorcentGold() + 1);
                        break;
                    case "Magic":
                        result.setPorcentMagic(result.getPorcentMagic() + 1);
                        break;
                    case "Gigan":
                        result.setPorcentGigant(result.getPorcentGigant() + 1);
                        break;
                }
            }
            return result;

        } catch (NullPointerException e) {
            resetFile();
        } catch (Exception ex) {
            Logger.getLogger(ChestService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
