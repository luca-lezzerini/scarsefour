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
 * @author User
 */
@Entity
public class Sconti implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate dallaData;
    @Column
    private LocalDate allaData;
    @Column
    double sconto;
    @Column
    String descrizione;
    @Column
    String codice;
    
    //Manca ManyToMany con gestione scaffali vendita::prodotto
    
    public Sconti() {
    }

    public Sconti(LocalDate dallaData, LocalDate allaData, double sconto, String descrizione, String codice) {
        this.dallaData = dallaData;
        this.allaData = allaData;
        this.sconto = sconto;
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDallaData() {
        return dallaData;
    }

    public void setDallaData(LocalDate dallaData) {
        this.dallaData = dallaData;
    }

    public LocalDate getAllaData() {
        return allaData;
    }

    public void setAllaData(LocalDate allaData) {
        this.allaData = allaData;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Sconti{" + "id=" + id + ", dallaData=" + dallaData + ", allaData=" + allaData + ", sconto=" + sconto + ", descrizione=" + descrizione + ", codice=" + codice + '}';
    }
    
}
