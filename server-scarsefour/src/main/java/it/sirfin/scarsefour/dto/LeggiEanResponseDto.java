package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import java.util.Set;

public class LeggiEanResponseDto {

    private Scontrino scontrino;
    private Set<RigaScontrino> righeScontrino;
    private String messaggio;
    private String barcode;

    public LeggiEanResponseDto() {
    }

    public LeggiEanResponseDto(Scontrino scontrino, Set<RigaScontrino> righeScontrino, String messaggio, String barcode) {
        this.scontrino = scontrino;
        this.righeScontrino = righeScontrino;
        this.messaggio = messaggio;
        this.barcode = barcode;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public Set<RigaScontrino> getRigheScontrino() {
        return righeScontrino;
    }

    public void setRigheScontrino(Set<RigaScontrino> righeScontrino) {
        this.righeScontrino = righeScontrino;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "LeggiEanResponseDto{" + "scontrino=" + scontrino + ", righeScontrino=" + righeScontrino + ", messaggio=" + messaggio + ", barcode=" + barcode + '}';
    }

    
}
