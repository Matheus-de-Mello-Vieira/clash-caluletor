package com.mycompany.clashcalculetor.Dao;

import com.mycompany.clashcalculetor.Models.Cart;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Models.Deck;
import com.mycompany.clashcalculetor.Util.Type.CartQuant;
import com.mycompany.clashcalculetor.Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class DeckDao {

    public List<Cart> getCarts(Deck deck) {
        ArrayList<Cart> arrayList = new ArrayList<Cart>(deck.getCartCollection());
        return arrayList;
    }

    public void addDeck(Cart[] carts, Deck deck) throws Exception {
        //add Deck
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        deck.setCartCollection(Arrays.asList(carts));
        session.save(deck);
        session.flush();
        session.getTransaction().commit();
        session.close();

        //add Carts
    }

    public List<CartQuant> orderCartByClient(int id) {
        Session session = HibernateUtil.getSession();
        NativeQuery<Object[]> querry = session.createNativeQuery("select count(*),c.name from deck d inner join cart_deck  cd on cd.id_deck=d.id_deck and (select count(*) from deck where id_client=" + id + ")-5<=d.id_deck inner join cart c on cd.id_cart=c.id_cart where d.id_client=" + id + " group by c.name order by count(*) desc");
        List<Object[]> list = querry.list();
        ArrayList<CartQuant> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CartQuant((Byte.parseByte(String.valueOf(list.get(i)[0]))), (String.valueOf(list.get(i)[1]))));
        }
        return result;
    }

    public List<CartQuant> orderByArena(int idArena) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Object[]> querry = session.createNativeQuery("select  count(*),c.name\n"
                + "    from cart c \n"
                + "    inner join cart_deck cd\n"
                + "    on cd.id_cart=c.id_cart\n"
                + "    	inner join deck d\n"
                + "    	on d.id_deck=cd.id_deck\n"
                + "            inner join `client` cl\n"
                + "            on  cl.id_client=d.id_client\n"
                + "    where cl.id_arena="+idArena+"\n"
                + "    group by c.name \n"
                + "    order by count(*) desc");
        List<Object[]> list = querry.getResultList();
        ArrayList<CartQuant> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CartQuant((Byte.parseByte(String.valueOf(list.get(i)[0]))), (String.valueOf(list.get(i)[1]))));
        }
        return result;
    }

    public List<CartQuant> orderCarts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Object[]> querry = session.createNativeQuery("select count(*),c.name from deck d inner join cart_deck  cd on cd.id_deck=d.id_deck and (select count(*) from deck)-101<=d.id_deck inner join cart c on cd.id_cart=c.id_cart group by c.name order by count(*) desc");
        List<Object[]> list = querry.getResultList();
        ArrayList<CartQuant> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CartQuant((Byte.parseByte(String.valueOf(list.get(i)[0]))), (String.valueOf(list.get(i)[1]))));
        }
        return result;
    }

    public List<Deck> listDeck() {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Deck.class);
        return criteria.list();
    }

    public List<Deck> listDeckByClient(Client client) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Deck> criteria = cb.createQuery(Deck.class);
        Root<Deck> root = criteria.from(Deck.class);
        criteria.where(cb.equal(root.get("idClient"), client));
        return session.createQuery(criteria).getResultList();
    }

}
