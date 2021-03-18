package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import java.util.List;

public class ListaCassieriDto {

    private List<Cassiera> listaCassieri;

    public ListaCassieriDto() {
    }

    public List<Cassiera> getListaCassieri() {
        return listaCassieri;
    }

    public void setListaCassieri(List<Cassiera> listaCassieri) {
        this.listaCassieri = listaCassieri;
    }

    public ListaCassieriDto(List<Cassiera> listaCassieri) {
        this.listaCassieri = listaCassieri;
    }

    @Override
    public String toString() {
        return "ListaCassieriDto{" + "listaCassieri=" + listaCassieri + '}';
    }

}
