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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mello
 */
@Entity
@Table(name = "deck")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deck.findAll", query = "SELECT d FROM Deck d")
    , @NamedQuery(name = "Deck.findByIdDeck", query = "SELECT d FROM Deck d WHERE d.idDeck = :idDeck")})
public class Deck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deck")
    private Short idDeck;
    
    @ManyToMany
    @JoinTable(name = "cart_deck", joinColumns = {
        @JoinColumn(name = "id_deck", referencedColumnName = "id_deck")}, inverseJoinColumns = {
        @JoinColumn(name = "id_cart", referencedColumnName = "id_cart")})
    private Collection<Cart> cartCollection;
    
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;

    public Deck() {
    }

    public Deck(Short idDeck) {
        this.idDeck = idDeck;
    }

    public Short getIdDeck() {
        return idDeck;
    }

    public void setIdDeck(Short idDeck) {
        this.idDeck = idDeck;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return Collections.unmodifiableCollection(cartCollection);
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeck != null ? idDeck.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deck)) {
            return false;
        }
        Deck other = (Deck) object;
        if ((this.idDeck == null && other.idDeck != null) || (this.idDeck != null && !this.idDeck.equals(other.idDeck))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clashcalculetor.Models.Deck[ idDeck=" + idDeck + " ]";
    }
    
}
