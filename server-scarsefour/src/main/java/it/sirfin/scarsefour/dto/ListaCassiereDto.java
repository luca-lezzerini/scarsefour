package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import java.util.List;

public class ListaCassiereDto {

    private List<Cassiera> listaCassiere;

    public ListaCassiereDto() {
    }

    public List<Cassiera> getListaCassieri() {
        return listaCassiere;
    }

    public void setListaCassieri(List<Cassiera> listaCassieri) {
        this.listaCassiere = listaCassieri;
    }

    public ListaCassiereDto(List<Cassiera> listaCassieri) {
        this.listaCassiere = listaCassieri;
    }

    @Override
    public String toString() {
        return "ListaCassieriDto{" + "listaCassieri=" + listaCassiere + '}';
    }

}
