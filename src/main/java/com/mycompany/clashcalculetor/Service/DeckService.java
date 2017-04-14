package com.mycompany.clashcalculetor.Service;

import com.mycompany.clashcalculetor.Dao.CartDao;
import com.mycompany.clashcalculetor.Dao.DeckDao;
import com.mycompany.clashcalculetor.Models.Cart;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Models.Deck;
import com.mycompany.clashcalculetor.Util.Type.CartQuant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.HibernateException;

public class DeckService {

    DeckDao deckDao;
    CartDao cartDao;
    public DeckService() {
        deckDao = new DeckDao();
        cartDao=new CartDao();
    }

    public List<Cart> getCarts(Deck deck) {
        return deckDao.getCarts(deck);
    }

    public List<CartQuant> OrderAll() {
        return deckDao.orderCarts();
    }

    public ArrayList<Cart> ListAll() {
        ArrayList<Cart> list=new ArrayList<>();
        for(Deck deck: deckDao.listDeck()){
            list.addAll(getCarts(deck));
        }
        return list;
    }
    public Cart[] ListAllCarts() {
        return cartDao.listAll();
    }
    public List<CartQuant> OrderByClient(Client client) {
        return deckDao.orderCartByClient(client.getIdClient());
    }

    public Cart[] ListByClient(Client client) {
        ArrayList<Cart> list=new ArrayList<>();
        for(Deck deck:deckDao.listDeckByClient(client)){
            list.addAll(getCarts(deck));
        }
        return list.toArray(new Cart[0]);
    }
    public List<Deck> listDecks(){
        return deckDao.listDeck();
    }
     public List<Deck> listDecks(Client client){
        return deckDao.listDeckByClient(client);
    }
    public boolean addDeck(Cart[] cart, Client client) {
        try{
        Deck deck = new Deck();
        deck.setIdClient(client);
        deckDao.addDeck(cart, deck);
        }catch(HibernateException he){
            return false;
        }
        return true;
    }
}
