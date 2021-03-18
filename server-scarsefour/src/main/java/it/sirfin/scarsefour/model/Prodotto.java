/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @JsonIgnoreProperties(value = "cassiera", allowSetters = true)
    @OneToMany(mappedBy = "cassiera")
    private Set<Scontrino> scontrini;

    public Prodotto() {
    }

    public Prodotto(String ean, String codice, String descrizione, double prezzo, int scortaMinimaScaf, int scortaMinimaMag, int lottoRiordino) {
        this.ean = ean;
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.scortaMinimaScaf = scortaMinimaScaf;
        this.scortaMinimaMag = scortaMinimaMag;
        this.lottoRiordino = lottoRiordino;
    }
    
    
}
