/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author manue
 */
@Entity
public class Sconto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate dallaData;
    @Column
    private LocalDate allaData;
    @Column
    private double sconto;
    @Column
    private String descrizione;
    @Column
    private String codice;

    public Sconto() {
    }

    public Sconto(LocalDate dallaData, LocalDate allaData, double sconto, String descrizione, String codice) {
        this.dallaData = dallaData;
        this.allaData = allaData;
        this.sconto = sconto;
        this.descrizione = descrizione;
        this.codice = codice;
    }
    
    

}
