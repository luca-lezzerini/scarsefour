package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Posizione;
import java.util.List;


public class ListaPosizioniDto {
    
    private List<Posizione> listaPosizioni;

    public ListaPosizioniDto() {
    }

    public ListaPosizioniDto(List<Posizione> listaPosizioni) {
        this.listaPosizioni = listaPosizioni;
    }

    public List<Posizione> getListaPosizioni() {
        return listaPosizioni;
    }

    public void setListaPosizioni(List<Posizione> listaPosizioni) {
        this.listaPosizioni = listaPosizioni;
    }

    @Override
    public String toString() {
        return "ListaPosizioniDto{" + "listaPosizioni=" + listaPosizioni + '}';
    }
}
