/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author manue
 */
@Entity
public class RigaScontrino implements Serializable {

    /* non sono stati creati ancora i get e set e il to string 
    perchè bisogna aggiungere le asscoiazioni prima */
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer quantita;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    @OneToOne(mappedBy = "rigascontrino")
    private MovimentiScaffale movimentiScaffale;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Scontrino scontrino;

    public RigaScontrino() {
    }

    public RigaScontrino(Integer quantità) {
        this.quantita = quantità;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public MovimentiScaffale getMovimentiScaffale() {
        return movimentiScaffale;
    }

    public void setMovimentiScaffale(MovimentiScaffale movimentiScaffale) {
        this.movimentiScaffale = movimentiScaffale;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

  

    @Override
    public String toString() {
        return "RigaScontrino{" + "id=" + id + ", quantita=" + quantita + ", prodotto=" + prodotto.getId() + ", movimentiScaffale=" + movimentiScaffale + ", scontrino=" + scontrino + '}';
    }
    
    

}
