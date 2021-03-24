package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Scontrino;


public class LeggiEanRequestDto {
    private Scontrino scontrino;
    private String eanProdotto;

    public LeggiEanRequestDto() {
    }

    public LeggiEanRequestDto(Scontrino scontrino, String eanProdotto) {
        this.scontrino = scontrino;
        this.eanProdotto = eanProdotto;
    }

    public Scontrino getScontrino() {
        return scontrino;
    }

    public void setScontrino(Scontrino scontrino) {
        this.scontrino = scontrino;
    }

    public String getEanProdotto() {
        return eanProdotto;
    }

    public void setEanProdotto(String eanProdotto) {
        this.eanProdotto = eanProdotto;
    }

    @Override
    public String toString() {
        return "LeggiEanRequstDto{" + "scontrino=" + scontrino + ", eanProdotto=" + eanProdotto + '}';
    }
    
    
}
