/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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
@Table(name = "arena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arena.findAll", query = "SELECT a FROM Arena a")
    , @NamedQuery(name = "Arena.findByIdArena", query = "SELECT a FROM Arena a WHERE a.idArena = :idArena")
    , @NamedQuery(name = "Arena.findByName", query = "SELECT a FROM Arena a WHERE a.name = :name")
    , @NamedQuery(name = "Arena.findByMinTrophy", query = "SELECT a FROM Arena a WHERE a.minTrophy = :minTrophy")})
public class Arena implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArena")
    private Collection<Client> clientCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arena")
    private Short idArena;
    @Column(name = "name")
    private String name;
    @Column(name = "min_trophy")
    private Integer minTrophy;

    public Arena() {
    }

    public Arena(Short idArena) {
        this.idArena = idArena;
    }

    public Short getIdArena() {
        return idArena;
    }

    public void setIdArena(Short idArena) {
        this.idArena = idArena;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinTrophy() {
        return minTrophy;
    }

    public void setMinTrophy(Integer minTrophy) {
        this.minTrophy = minTrophy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArena != null ? idArena.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arena)) {
            return false;
        }
        Arena other = (Arena) object;
        if ((this.idArena == null && other.idArena != null) || (this.idArena != null && !this.idArena.equals(other.idArena))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clashcalculetor.Models.Arena[ idArena=" + idArena + " ]";
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return Collections.unmodifiableCollection(clientCollection);
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }
    
}
