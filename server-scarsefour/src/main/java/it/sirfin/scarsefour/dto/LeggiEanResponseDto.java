package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;


public class LeggiEanResponseDto {
    private Scontrino scontrino;
    private RigaScontrino rigaScontrino;
    private String messaggio;

    public LeggiEanResponseDto() {
    }

    public LeggiEanResponseDto(Scontrino scontrino, RigaScontrino rigaScontrino, String messaggio) {
        this.scontrino = scontrino;
        this.rigaScontrino = rigaScontrino;
        this.messaggio = messaggio;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public RigaScontrino getRigaScontrino() {
        return rigaScontrino;
    }

    public void setRigaScontrino(RigaScontrino rigaScontrino) {
        this.rigaScontrino = rigaScontrino;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "LeggiEanResponseDto{" + "scontrino=" + scontrino.getId() + ", rigaScontrino=" + rigaScontrino.getId() + ", messaggio=" + messaggio + '}';
    }
    
    
}
