/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Sconto;

/**
 *
 * @author Userù
 */
public class ScontiDto {
    
    private Sconto sconto;

    public ScontiDto() {
    }

    public ScontiDto(Sconto sconto) {
        this.sconto = sconto;
    }

    public Sconto getSconto() {
        return sconto;
    }

    public void setSconto(Sconto sconto) {
        this.sconto = sconto;
    }

    @Override
    public String toString() {
        return "ScontiDto{" + "sconto=" + sconto + '}';
    }
    
    
}
