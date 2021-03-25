package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import java.util.Set;

public class LeggiEanResponseDto {

    private Scontrino scontrino;
    private RigaScontrino RigaScontrino;
    private String messaggio;

    public LeggiEanResponseDto() {
    }

    public LeggiEanResponseDto(Scontrino scontrino, RigaScontrino RigaScontrino, String messaggio) {
        this.scontrino = scontrino;
        this.RigaScontrino = RigaScontrino;
        this.messaggio = messaggio;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public RigaScontrino getRigaScontrino() {
        return RigaScontrino;
    }

    public void setRigaScontrino(RigaScontrino RigaScontrino) {
        this.RigaScontrino = RigaScontrino;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "LeggiEanResponseDto{" + "scontrino=" + scontrino.getId() + ", RigaScontrino=" + RigaScontrino.getId() + ", messaggio=" + messaggio + '}';
    }
   
}
