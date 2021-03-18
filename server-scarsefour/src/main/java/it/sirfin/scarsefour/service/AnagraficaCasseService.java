package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ListaCasseDto;
import it.sirfin.scarsefour.model.Cassa;


public interface AnagraficaCasseService {
    
    ListaCasseDto aggiungiCassa(Cassa cassa);
    
    ListaCasseDto aggiornaCassa();
    
    ListaCasseDto rimuoviCassa(Cassa cassa);
    
    ListaCasseDto modificaCassa(Cassa cassa);
    
    ListaCasseDto cercaCassaLike(String codice);
}
