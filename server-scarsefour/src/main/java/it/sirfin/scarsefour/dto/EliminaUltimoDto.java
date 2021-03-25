/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;

public class EliminaUltimoDto {
    
    private RigaScontrino rigaScontrino; 
    private Scontrino scontrino;

    public EliminaUltimoDto() {
    }

    public EliminaUltimoDto(RigaScontrino rigaScontrino, Scontrino scontrino) {
        this.rigaScontrino = rigaScontrino;
        this.scontrino = scontrino;
    }

    public RigaScontrino getRigaScontrino() {
        return rigaScontrino;
    }

    public void setRigaScontrino(RigaScontrino rigaScontrino) {
        this.rigaScontrino = rigaScontrino;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    @Override
    public String toString() {
        return "EliminaUltimoDto{" + "rigaScontrino=" + rigaScontrino + ", scontrino=" + scontrino + '}';
    }
    
    


    
}
