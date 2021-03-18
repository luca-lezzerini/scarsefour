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
public class Cassiera implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String codiceFiscale;

    @JsonIgnoreProperties(value = "cassiera", allowSetters = true)
    @OneToMany(mappedBy = "cassiera")
    private Set<Scontrino> scontrini;

    public Cassiera() {
    }

    public Cassiera(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Set<Scontrino> getScontrini() {
        if (scontrini == null) {
            scontrini = new HashSet<>();
        }
        return scontrini;
    }

    public void setScontrini(Set<Scontrino> scontrini) {
        if (scontrini == null) {
            scontrini = new HashSet<>();
        }
        this.scontrini = scontrini;
    }

    @Override
    public String toString() {
        return "Cassiera{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", scontrini=" + scontrini + '}';
    }

}
