package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import java.util.List;

public class AnnullaScontrinoDto {
    
    private Scontrino scontrino;
    private List<RigaScontrino> righeScontrino;

    public AnnullaScontrinoDto() {
    }

    public AnnullaScontrinoDto(Scontrino scontrino, List<RigaScontrino> righeScontrino) {
        this.scontrino = scontrino;
        this.righeScontrino = righeScontrino;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public List<RigaScontrino> getRigheScontrino() {
        return righeScontrino;
    }

    public void setRigheScontrino(List<RigaScontrino> righeScontrino) {
        this.righeScontrino = righeScontrino;
    }
    
     
}
