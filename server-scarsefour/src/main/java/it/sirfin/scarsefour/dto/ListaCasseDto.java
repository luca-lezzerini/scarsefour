package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Cassa;
import java.util.List;

public class ListaCasseDto {
    private List<Cassa> listaCasse;

    public ListaCasseDto() {
    }

    public ListaCasseDto(List<Cassa> listaCasse) {
        this.listaCasse = listaCasse;
    }

    public List<Cassa> getListaCasse() {
        return listaCasse;
    }

    public void setListaCasse(List<Cassa> listaCasse) {
        this.listaCasse = listaCasse;
    }

    @Override
    public String toString() {
        return "ListaCasseDto{" + "listaCasse=" + listaCasse + '}';
    }
    
    
}
