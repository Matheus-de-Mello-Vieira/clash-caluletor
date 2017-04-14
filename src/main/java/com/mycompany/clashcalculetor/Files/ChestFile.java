package com.mycompany.clashcalculetor.Files;

import com.mycompany.clashcalculetor.Models.Chest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ChestFile {

    public Integer[] read() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("chest.txt")));
        String[] valors = bufferedReader.readLine().split(",");
        for (String valor : valors) {
            list.add(Integer.parseInt(valor));
        }
        bufferedReader.close();
        return list.toArray(new Integer[0]);
    }

    public void createFile() {
        try {
            File file = new File("chest.txt");
            file.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Create new chest.txt Falied");
        }
    }
   
    public void writeListc(List<Chest> chests) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("chest.txt")));
        //delete all
        bufferedWriter.write("");
        for (int i = 0; i < 240 && i < chests.size() - 1; i++) {
            bufferedWriter.append(chests.get(i).getIdChest() + ",");
        }
        bufferedWriter.append(chests.get(chests.size() - 1).getIdChest() + "");
        bufferedWriter.close();
    }
    public void deleteFile(){
        File file = new File("chest.txt");
        file.delete();
    }
    public void writeList(List<Integer> chests) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("chest.txt")));
        //delete all
        bufferedWriter.write("");
        for (int i = 0; i < 240 && i < chests.size() - 1; i++) {
            bufferedWriter.append(chests.get(i) + ",");
        }
        bufferedWriter.append(chests.get(chests.size() - 1) + "");
        bufferedWriter.close();
    }

}
