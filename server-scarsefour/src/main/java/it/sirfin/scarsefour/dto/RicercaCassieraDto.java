/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

/**
 *
 * @author Utente
 */
public class RicercaCassieraDto {

    private String criterioRicerca;

    public RicercaCassieraDto() {
    }

    public RicercaCassieraDto(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    @Override
    public String toString() {
        return "RicercaCassieraDto{" + "criterioRicerca=" + criterioRicerca + '}';
    }

}
