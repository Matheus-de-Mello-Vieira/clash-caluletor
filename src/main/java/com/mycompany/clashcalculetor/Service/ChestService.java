package com.mycompany.clashcalculetor.Service;

import com.mycompany.clashcalculetor.Dao.ChestDao;
import com.mycompany.clashcalculetor.Files.ChestFile;
import com.mycompany.clashcalculetor.Models.Chest;
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

    ChestDao chestDao;
    ChestFile chestFile;

    public ChestService() {
        chestDao = new ChestDao();
        chestFile = new ChestFile();
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

    public void nextChest(String chest) {
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
                    if(possibleChest.isEmpty()){
                        throw new InvalidChestException();
                    }
                    chestFile.writeListc(possibleChest);
                }catch(InvalidChestException e){
                    JOptionPane.showMessageDialog(null, e.getText());
                }catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Erro, null in nextChest(String)");

                } catch (Exception e) {
                    System.out.println(idChest + "\n");
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(ChestService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            chestFile.writeList(Arrays.asList(results));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Erro, null in nextChest()");
        } catch (Exception e) {

        }
    }

    public NextChest calculetorNextChest() {
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

        } catch (Exception ex) {
            Logger.getLogger(ChestService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
