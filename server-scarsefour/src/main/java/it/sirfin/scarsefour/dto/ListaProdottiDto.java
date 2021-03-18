package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.model.Prodotto;
import java.util.Set;

public class ListaProdottiDto {

    private Set<Prodotto> listaProdotti;

    public ListaProdottiDto() {
    }

    public ListaProdottiDto(Set<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public Set<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(Set<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    @Override
    public String toString() {
        return "ListaProdottiDto{" + "listaProdotti=" + listaProdotti + '}';
    }
    
    

   
}
