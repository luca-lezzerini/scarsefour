package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;

public interface GestioneCassaHisService {

    LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto);

    public void demoAssociaScontrinoARigaSco();

    public void demoAssociaRigaScoAProdotto();

    public void demoAggiornaTotScontrino();

    void demoCreaNuovoScontrino();
}
