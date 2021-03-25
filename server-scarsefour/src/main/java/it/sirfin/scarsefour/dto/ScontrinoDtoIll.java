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

    private List<RigaScontrinoClientDto> righeScontrino;
    private Scontrino scontrino;
    private String messaggio;

    public ScontrinoDtoIll() {
    }

    public ScontrinoDtoIll(List<RigaScontrinoClientDto> righeScontrino, Scontrino scontrino, String messaggio) {
        this.righeScontrino = righeScontrino;
        this.scontrino = scontrino;
        this.messaggio = messaggio;
    }

    public List<RigaScontrinoClientDto> getRigheScontrino() {
        return righeScontrino;
    }

    public void setRigheScontrino(List<RigaScontrinoClientDto> righeScontrino) {
        this.righeScontrino = righeScontrino;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "ScontrinoDtoIll{" + "righeScontrino=" + righeScontrino + ", scontrino=" + scontrino + ", messaggio=" + messaggio + '}';
    }

}
