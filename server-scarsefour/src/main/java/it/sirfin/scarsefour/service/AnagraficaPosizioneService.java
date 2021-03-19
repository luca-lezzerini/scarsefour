package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ListaPosizioniDto;
import it.sirfin.scarsefour.model.Cassa;
import it.sirfin.scarsefour.model.Posizione;

public interface AnagraficaPosizioneService {

    ListaPosizioniDto aggiungiPosizione(Posizione posizione);

    ListaPosizioniDto aggiornaPosizione();

    ListaPosizioniDto rimuoviPosizione(Posizione posizione);

    ListaPosizioniDto modificaPosizione(Posizione posizione);

    ListaPosizioniDto cercaPosizioneLike (String codice,String descrizione);
}
