package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import java.util.Set;

public class ListaCassieriDto {

    private Set<Cassiera> listaCassieri;

    public ListaCassieriDto() {
    }

    public ListaCassieriDto(Set<Cassiera> listaCassieri) {
        this.listaCassieri = listaCassieri;
    }

    public Set<Cassiera> getListaCassieri() {
        return listaCassieri;
    }

    public void setListaCassieri(Set<Cassiera> listaCassieri) {
        this.listaCassieri = listaCassieri;
    }

    @Override
    public String toString() {
        return "ListaCassieriDto{" + "listaCassieri=" + listaCassieri + '}';
    }

}
