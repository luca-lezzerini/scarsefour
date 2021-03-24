/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Scontrino implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDateTime timestamp;
    @Column
    private Integer numero;
    @Column
    private Double totale;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cassiera cassiera;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cassa cassa;

    @JsonIgnoreProperties(value = "scontrino")
    @OneToMany(mappedBy = "scontrino")
    private Set<RigaScontrino> righeScontrino;

    public Scontrino() {
    }

    public Scontrino(LocalDateTime timestamp, Integer numero, Double totale) {
        this.timestamp = timestamp;
        this.numero = numero;
        this.totale = totale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public Cassiera getCassiera() {
        return cassiera;
    }

    public void setCassiera(Cassiera cassiera) {
        this.cassiera = cassiera;
    }

    public Cassa getCassa() {
        return cassa;
    }

    public void setCassa(Cassa cassa) {
        this.cassa = cassa;
    }

    public Set<RigaScontrino> getRigheScontrino() {
        return righeScontrino;
    }

    public void setRigheScontrino(Set<RigaScontrino> righeScontrino) {
        this.righeScontrino = righeScontrino;
    }
    

    @Override
    public String toString() {
        return "Scontrino{" + "id=" + id + ", timestamp=" + timestamp + ", numero=" + numero + ", totale=" + totale + '}';
    }

}
