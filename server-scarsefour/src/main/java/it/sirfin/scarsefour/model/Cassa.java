package it.sirfin.scarsefour.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cassa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    @JsonIgnoreProperties(value = "cassa", allowSetters = true)
    @OneToMany(mappedBy = "cassa")
    private Set<Scontrino> scontrini;

    public Cassa() {
    }

    public Cassa(String codice) {
        this.codice = codice;
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

    @Override
    public String toString() {
        return "Cassa{" + "id=" + id + ", codice=" + codice + ",numero scontrini=" + scontrini.size() + '}';
    }

}
