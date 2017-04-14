/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Util.TableModel;

import com.mycompany.clashcalculetor.Models.Cart;
import com.mycompany.clashcalculetor.Models.Deck;
import com.mycompany.clashcalculetor.Service.DeckService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mello
 */
public class CartListTableModel extends AbstractTableModel {

    private List<Deck> list;
    private DeckService deckService;
    public CartListTableModel(List<Deck> list) {
        this.list = list;
        deckService=new DeckService();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int i, int j) {
        ArrayList<Cart> cartList = new ArrayList<>(deckService.getCarts(this.list.get(i)));
       if(j<9){
           return cartList.get(j).getName();
        }
       return null;
    }

    @Override
    public String getColumnName(int i) {
        return "cart "+(i+1);
    }
}
