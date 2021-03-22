/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

public class ReqEanDtoGal {

    private String barcode;

    public ReqEanDtoGal() {
    }

    public ReqEanDtoGal(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "ReqEanDtoGal{" + "barcode=" + barcode + '}';
    }

}
