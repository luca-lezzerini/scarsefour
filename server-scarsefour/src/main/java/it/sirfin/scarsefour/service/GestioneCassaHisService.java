package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;

public interface GestioneCassaHisService {

    LeggiEanResponseDto leggiEan(String barcode);

    CreaScontrinoDto salvaScontrino(Scontrino scontrino);

    CreaRigaDto salvaRiga(RigaScontrino riga);

    public void demoAssociaScontrinoARigaSco();

    public void demoAssociaRigaScoAProdotto();

    public void demoAggiornaTotScontrino();

    public void demoCreaNuovoScontrino();
}
