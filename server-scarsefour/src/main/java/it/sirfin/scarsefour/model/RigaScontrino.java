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
    private Integer quantità;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;
    
    public RigaScontrino() {
    }

    public RigaScontrino(Integer quantità) {
        this.quantità = quantità;
    }

}
