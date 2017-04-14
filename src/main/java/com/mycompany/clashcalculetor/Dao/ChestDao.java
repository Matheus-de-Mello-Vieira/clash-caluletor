package com.mycompany.clashcalculetor.Dao;

import com.mycompany.clashcalculetor.Models.Cart;
import com.mycompany.clashcalculetor.Models.Chest;
import com.mycompany.clashcalculetor.Util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ChestDao {

    public Chest[] findByName(String name) {
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Chest> criteria= cb.createQuery(Chest.class);
        Root<Chest> root = criteria.from(Chest.class);
        criteria.where(cb.equal(root.get("name"), name));
        return session.createQuery(criteria).getResultList().toArray(new Chest[0]);
    }

    public Chest findById(Integer id) {
        Session session = HibernateUtil.getSession();
        return session.find(Chest.class, id);
    }
    public List<Chest> listAll(){
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Chest> criteria= cb.createQuery(Chest.class);
        criteria.from(Chest.class);
        return session.createQuery(criteria).getResultList();
    }
}
