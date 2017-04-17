/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clashcalculetor.Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mello
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient")
    , @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name")
    , @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "id_arena", referencedColumnName = "id_arena")
    @ManyToOne(optional = false)
    private Arena idArena;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Short idClient;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Deck> deckCollection;
    @JoinColumn(name = "id_current_chest", referencedColumnName = "id_chest")
    @ManyToOne()
    private Chest idCurrentChest;

    public Client() {

    }

    public Client(Short idClient) {
        this.idClient = idClient;
    }

    public Client(Short idClient, String name, String password, Arena arena) {
        this.idClient = idClient;
        this.name = name;
        this.password = password;
        this.idArena = arena;
    }

    public Short getIdClient() {
        return idClient;
    }

    public void setIdClient(Short idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Deck> getDeckCollection() {
        return Collections.unmodifiableCollection(deckCollection);
    }

    public void setDeckCollection(Collection<Deck> deckCollection) {
        this.deckCollection = deckCollection;
    }

    public Chest getIdCurrentChest() {
        return idCurrentChest;
    }

    public void setIdCurrentChest(Chest idCurrentChest) {
        this.idCurrentChest = idCurrentChest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clashcalculetor.Models.Client[ idClient=" + idClient + " ]";
    }

    public Arena getIdArena() {
        return idArena;
    }

    public void setIdArena(Arena idArena) {
        this.idArena = idArena;
    }

}
