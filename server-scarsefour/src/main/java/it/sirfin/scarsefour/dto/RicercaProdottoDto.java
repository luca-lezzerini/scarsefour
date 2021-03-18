/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

/**
 *
 * @author manue
 */
public class RicercaProdottoDto {
    
    private String ricercaPerCodice;

    public RicercaProdottoDto() {
    }

    public RicercaProdottoDto(String ricercaPerCodice) {
        this.ricercaPerCodice = ricercaPerCodice;
    }

    public String getRicercaPerCodice() {
        return ricercaPerCodice;
    }

    public void setRicercaPerCodice(String ricercaPerCodice) {
        this.ricercaPerCodice = ricercaPerCodice;
    }

    @Override
    public String toString() {
        return "RicercaProdottoDto{" + "ricercaPerCodice=" + ricercaPerCodice + '}';
    }
    
    
}
