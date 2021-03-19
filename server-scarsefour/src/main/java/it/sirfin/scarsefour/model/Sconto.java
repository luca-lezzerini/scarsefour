/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Sconto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String codice;
    @Column
    private String descrizione;
    @Column
    private double prezzoScontato;
    @Column
    private LocalDate dallaData;
    @Column
    private LocalDate allaData;
    

    @JsonIgnoreProperties(value = "sconto", allowSetters = true)
    @ManyToMany(mappedBy = "sconti")
    private Set<Prodotto> prodotti;

    public Sconto() {
    }

    public Sconto(String codice, String descrizione, double prezzoScontato, LocalDate dallaData, LocalDate allaData) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzoScontato = prezzoScontato;
        this.dallaData = dallaData;
        this.allaData = allaData;
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
        return prezzoScontato;
    }

    public void setSconto(double sconto) {
        this.prezzoScontato = sconto;
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

    public Set<Prodotto> getProdotti() {
        if (prodotti == null) {
            prodotti = new HashSet<>();
        }
        return prodotti;
    }

    public void setProdotti(Set<Prodotto> prodotti) {
        if (prodotti == null) {
            prodotti = new HashSet<>();
        }
        this.prodotti = prodotti;
    }

    @Override
    public String toString() {
        return "Sconto{" + "id=" + id + ", dallaData=" + dallaData + ", allaData=" + allaData + ", sconto=" + prezzoScontato + ", descrizione=" + descrizione + ", codice=" + codice + ", prodotti=" + prodotti + '}';
    }

}
