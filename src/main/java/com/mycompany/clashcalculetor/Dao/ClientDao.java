package com.mycompany.clashcalculetor.Dao;

import com.mycompany.clashcalculetor.Models.Chest;
import com.mycompany.clashcalculetor.Util.HibernateUtil;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Service.ClientService;
import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ClientDao {

    /**
     *
     * @param id find client by id
     * @return Client
     */
    public Client findBy(int id) {
        Session session = HibernateUtil.getSession();
        return session.find(Client.class, id);
    }

    /**
     *
     * @param name find client by name
     * @return Client
     */
    public Client findBy(String name) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteria = cb.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.where(cb.equal(root.get("name"), name));
        return session.createQuery(criteria).getSingleResult();
    }

    /**
     *
     * @param client register a client at system
     */
    public void singUp(Client client) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        session.flush();
        transaction.commit();
        session.close();
    }

    /**
     *
     * @param user
     * @param password confirm the user and password
     * @return
     */
    public boolean singIn(String user, String password) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteria = cb.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.where(cb.equal(root.get("name"), user));
        criteria.where(cb.equal(root.get("password"), password));
        return !session.createQuery(criteria).getResultList().isEmpty();
    }
     public void update(Client client){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        client.getIdArena();
        session.merge(client);
        session.flush();
        transaction.commit();
        session.close();
    }
}
