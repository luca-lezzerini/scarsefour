package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassieriDto;
import it.sirfin.scarsefour.model.Cassiera;

public interface AnagraficaCassiereService {

    ListaCassieriDto aggiungiCassiera(Cassiera cas);

    ListaCassieriDto rimuoviCassiera(Cassiera cas);

    ListaCassieriDto ricercaCassiera(String c);

    CassieraDto modificaCassiera(Cassiera cas);

    ListaCassieriDto confermaModifica(Cassiera cas);

    ListaCassieriDto aggiornaCassieri();
}
