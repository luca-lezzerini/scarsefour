package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.model.Prodotto;
import java.util.List;
import java.util.Set;

public class ListaProdottiDto {

    private List<Prodotto> listaProdotti;

    public ListaProdottiDto() {
    }

    public ListaProdottiDto(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    @Override
    public String toString() {
        return "ListaProdottiDto{" + "listaProdotti=" + listaProdotti + '}';
    }
     
}
