package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.AnnullaScontrinoDto;
import java.util.List;
import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.StornaRitornoDto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;

public interface GestioneCassaHisService {

    LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto);

    public void demoAssociaScontrinoARigaSco();

    public void demoAssociaRigaScoAProdotto();

    public void demoAggiornaTotScontrino();

    void demoCreaNuovoScontrino();

    AnnullaScontrinoDto annullaScontrino(Scontrino scontrino,List<RigaScontrino> righeScontrino);
    
    StornaRitornoDto stornaUltimo(RigaScontrino rs , Scontrino s);
}
