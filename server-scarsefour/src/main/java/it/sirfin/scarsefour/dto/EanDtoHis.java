
package it.sirfin.scarsefour.dto;


public class EanDtoHis {
    
    private String barcode;

    public EanDtoHis() {
    }

    public EanDtoHis(String barcode) {
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
        return "EanDtoHis{" + "barcode=" + barcode + '}';
    }
}
