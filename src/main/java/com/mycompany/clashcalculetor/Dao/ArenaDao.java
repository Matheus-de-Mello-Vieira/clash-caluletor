/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Dao;

import com.mycompany.clashcalculetor.Models.Arena;
import com.mycompany.clashcalculetor.Models.Client;
import com.mycompany.clashcalculetor.Util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author mello
 */
public class ArenaDao {
    public Arena findBy(short id){
        Session session=HibernateUtil.getSession();
        return session.find(Arena.class, id);
    }
    public Arena findBy(String name){
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Arena> criteria= cb.createQuery(Arena.class);
        Root<Arena> root = criteria.from(Arena.class);
        criteria.where(cb.equal(root.get("name"), name));
        return session.createQuery(criteria).getSingleResult();
    }
    public Arena findBy(Integer trophy){
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Arena> criteria= cb.createQuery(Arena.class);
        Root<Arena> root = criteria.from(Arena.class);
        criteria.where(cb.ge(root.get("minTrophy"), trophy));
        return session.createQuery(criteria).getResultList().get(0);
    }
    public List<Arena> listAll(){
        Session session=HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Arena> criteria= cb.createQuery(Arena.class);
        criteria.from(Arena.class);
        return session.createQuery(criteria).getResultList();
    }
   
}
