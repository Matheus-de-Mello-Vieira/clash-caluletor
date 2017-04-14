/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.TableModel;

import com.mycompany.clashcalculetor.Util.Type.CartQuant;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mello
 */
public class CartOrderTableModel extends AbstractTableModel {
    private List<CartQuant> list;
    public CartOrderTableModel(List<CartQuant> list){
        this.list=list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int j) {
        switch(j){
            case 0:
                return list.get(i).getName();
            case 1:
                return list.get(i).getQuant();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Cart";
            case 1:
                return "Count";
        }
        return null;
    }
}
