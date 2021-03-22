/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

/**
 *
 * @author Palo
 */
public class ReqEanDtoIll {

    private String codiceABarre;

    public ReqEanDtoIll() {
    }

    public ReqEanDtoIll(String codiceABarre) {
        this.codiceABarre = codiceABarre;
    }

    public String getCodiceABarre() {
        return codiceABarre;
    }

    public void setCodiceABarre(String codiceABarre) {
        this.codiceABarre = codiceABarre;
    }

}
