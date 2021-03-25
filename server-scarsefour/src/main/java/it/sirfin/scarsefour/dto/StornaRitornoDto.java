
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import java.util.List;
import java.util.Set;


public class StornaRitornoDto {
    
   private Set<RigaScontrino> righe;

    public StornaRitornoDto() {
    }

    public StornaRitornoDto(Set<RigaScontrino> righe) {
        this.righe = righe;
    }

    public Set<RigaScontrino> getRighe() {
        return righe;
    }

    public void setRighe(Set<RigaScontrino> righe) {
        this.righe = righe;
    }

    @Override
    public String toString() {
        return "StornaRitornoDto{" + "righe=" + righe + '}';
    }
   
   
}
