
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;

public class CreaRigaDto {
    
    RigaScontrino riga;

    public CreaRigaDto() {
    }

    public CreaRigaDto(RigaScontrino riga) {
        this.riga = riga;
    }

    public RigaScontrino getRiga() {
        return riga;
    }

    public void setRiga(RigaScontrino riga) {
        this.riga = riga;
    }

    @Override
    public String toString() {
        return "CreaRigaDto{" + "riga=" + riga + '}';
    }
    
     
}
