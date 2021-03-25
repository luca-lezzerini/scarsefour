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
 * @author aleur
 */
public class LeggiEanResponseMacDto {
    private Scontrino scontrino;
    private List<RigaScontrino> rigaScontrino;
    private String messaggio;

    public LeggiEanResponseMacDto() {
    }

    public LeggiEanResponseMacDto(Scontrino scontrino, List<RigaScontrino> rigaScontrino, String messaggio) {
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

    public List<RigaScontrino> getRigaScontrino() {
        return rigaScontrino;
    }

    public void setRigaScontrino(List<RigaScontrino> rigaScontrino) {
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
        return "LeggiEanResponseMacDto{" + "scontrino=" + scontrino + ", rigaScontrino=" + rigaScontrino + ", messaggio=" + messaggio + '}';
    }
    
    
}
