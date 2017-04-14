package com.mycompany.clashcalculetor.Dao;

import com.mycompany.clashcalculetor.Models.Cart;
import com.mycompany.clashcalculetor.Util.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CartDao {

    public CartDao() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cart findByName(String name) {
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Cart> criteria= cb.createQuery(Cart.class);
        Root<Cart> root = criteria.from(Cart.class);
        criteria.where(cb.equal(root.get("name"), name));
        return session.createQuery(criteria).getSingleResult();
    }
    public Cart[] listAll(){
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Cart> criteria= cb.createQuery(Cart.class);
        criteria.from(Cart.class);
        return session.createQuery(criteria).getResultList().toArray(new Cart[0]);
    }
    public Cart findById(int id) {
        Session session=HibernateUtil.getSession();
        return session.find(Cart.class, id);
    }

}
