package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.AnnullaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import java.util.List;

public interface GestioneCassaHisService {

    LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto);

    public void demoAssociaScontrinoARigaSco();

    public void demoAssociaRigaScoAProdotto();

    public void demoAggiornaTotScontrino();

    void demoCreaNuovoScontrino();

    AnnullaScontrinoDto annullaScontrino(Scontrino scontrino,List<RigaScontrino> righeScontrino);
}
