package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassiereDto;
import it.sirfin.scarsefour.model.Cassiera;

public interface AnagraficaCassiereService {

    ListaCassiereDto aggiungiCassiera(Cassiera cas);

    ListaCassiereDto rimuoviCassiera(Cassiera cas);

    ListaCassiereDto ricercaCassiera(String c);

    ListaCassiereDto confermaModifica(Cassiera cas);

    ListaCassiereDto aggiornaCassieri();
}
