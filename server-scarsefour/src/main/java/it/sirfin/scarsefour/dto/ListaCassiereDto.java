package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import java.util.List;

public class ListaCassiereDto {

    private List<Cassiera> listaCassiere;

    public ListaCassiereDto() {
    }

    public ListaCassiereDto(List<Cassiera> listaCassiere) {
        this.listaCassiere = listaCassiere;
    }

    public List<Cassiera> getListaCassiere() {
        return listaCassiere;
    }

    public void setListaCassiere(List<Cassiera> listaCassiere) {
        this.listaCassiere = listaCassiere;
    }

    @Override
    public String toString() {
        return "ListaCassiereDto{" + "listaCassiere=" + listaCassiere + '}';
    }

}
