/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String ean;
    @Column
    private String codice;
    @Column
    private String descrizione;
    @Column
    private double prezzo;
    @Column
    private int scortaMinimaScaf;
    @Column
    private int scortaMinimaMag;
    @Column
    private int lottoRiordino;

    @JsonIgnoreProperties(value = "prodotto", allowSetters = true)
    @ManyToMany
    private Set<Sconto> sconti;
    
    @OneToMany(mappedBy = "prodotto")
    private List<RigaScontrino> righeScontrini;
    
    
    public Prodotto() {
    }

    public Prodotto(String ean, String codice, String descrizione, double prezzo, int scortaMinimaScaf, int scortaMinimaMag, int lottoRiordino, Set<Sconto> sconti) {
        this.ean = ean;
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.scortaMinimaScaf = scortaMinimaScaf;
        this.scortaMinimaMag = scortaMinimaMag;
        this.lottoRiordino = lottoRiordino;
        this.sconti = sconti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getScortaMinimaScaf() {
        return scortaMinimaScaf;
    }

    public void setScortaMinimaScaf(int scortaMinimaScaf) {
        this.scortaMinimaScaf = scortaMinimaScaf;
    }

    public int getScortaMinimaMag() {
        return scortaMinimaMag;
    }

    public void setScortaMinimaMag(int scortaMinimaMag) {
        this.scortaMinimaMag = scortaMinimaMag;
    }

    public int getLottoRiordino() {
        return lottoRiordino;
    }

    public void setLottoRiordino(int lottoRiordino) {
        this.lottoRiordino = lottoRiordino;
    }

    public Set<Sconto> getSconti() {
        if (sconti == null) {
            new ArrayList<>();
        }
        return sconti;
    }

    public void setSconti(Set<Sconto> sconti) {
        this.sconti = sconti;
    }

    public List<RigaScontrino> getRigheScontrini() {
        return righeScontrini;
    }

    public void setRigheScontrini(List<RigaScontrino> righeScontrini) {
        this.righeScontrini = righeScontrini;
    }
    

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", ean=" + ean + ", codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", scortaMinimaScaf=" + scortaMinimaScaf + ", scortaMinimaMag=" + scortaMinimaMag + ", lottoRiordino=" + lottoRiordino + ", sconti=" + sconti + '}';
    }

}
