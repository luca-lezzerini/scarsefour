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
import java.util.List;
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
    private List<Prodotto> prodotti;

    public Sconto() {
    }

    public Sconto(String codice, String descrizione, double prezzoScontato, LocalDate dallaData, LocalDate allaData, List<Prodotto> prodotti) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzoScontato = prezzoScontato;
        this.dallaData = dallaData;
        this.allaData = allaData;
        this.prodotti = prodotti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzoScontato() {
        return prezzoScontato;
    }

    public void setPrezzoScontato(double prezzoScontato) {
        this.prezzoScontato = prezzoScontato;
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

    public List<Prodotto> getProdotti() {
        if (prodotti == null) {
            new ArrayList<>();
        }
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public String toString() {
        return "Sconto{" + "id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", prezzoScontato=" + prezzoScontato + ", dallaData=" + dallaData + ", allaData=" + allaData + ", prodotti=" + prodotti + '}';
    }

    

}
