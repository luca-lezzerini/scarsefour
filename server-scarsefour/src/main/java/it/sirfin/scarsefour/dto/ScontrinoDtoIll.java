/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import java.util.List;

/**
 *
 * @author Palo
 */
public class ScontrinoDtoIll {

    private List<RigaScontrino> righeScontrino;
    private Scontrino scontrino;

    public ScontrinoDtoIll() {
    }

    public ScontrinoDtoIll(List<RigaScontrino> righeScontrino, Scontrino scontrino) {
        this.righeScontrino = righeScontrino;
        this.scontrino = scontrino;
    }

    public List<RigaScontrino> getRigheScontrino() {
        return righeScontrino;
    }

    public void setRigheScontrino(List<RigaScontrino> righeScontrino) {
        this.righeScontrino = righeScontrino;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    @Override
    public String toString() {
        return "ScontrinoDtoIll{" + "righeScontrino=" + righeScontrino + ", scontrino=" + scontrino + '}';
    }

}
