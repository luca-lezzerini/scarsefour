package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Scontrino;


public class CreaScontrinoDto {
    
    private Scontrino scontrino;

    public CreaScontrinoDto() {
    }

    public CreaScontrinoDto(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    @Override
    public String toString() {
        return "CreaScontrinoDto{" + "scontrino=" + scontrino + '}';
    }
    
    
}
