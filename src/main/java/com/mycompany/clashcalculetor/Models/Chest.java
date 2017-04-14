/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mello
 */
@Entity
@Table(name = "chest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chest.findAll", query = "SELECT c FROM Chest c")
    , @NamedQuery(name = "Chest.findByIdChest", query = "SELECT c FROM Chest c WHERE c.idChest = :idChest")
    , @NamedQuery(name = "Chest.findByName", query = "SELECT c FROM Chest c WHERE c.name = :name")})
public class Chest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chest")
    private Integer idChest;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idCurrentChest")
    private Collection<Client> clientCollection;

    public Chest() {
    }

    public Chest(int idChest) {
        this.idChest = idChest;
    }

    public Integer getIdChest() {
        return idChest;
    }

    public void setIdChest(Integer idChest) {
        this.idChest = idChest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChest != null ? idChest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chest)) {
            return false;
        }
        Chest other = (Chest) object;
        if ((this.idChest == null && other.idChest != null) || (this.idChest != null && !this.idChest.equals(other.idChest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clashcalculetor.Models.Chest[ idChest=" + idChest + " ]";
    }
    
}
