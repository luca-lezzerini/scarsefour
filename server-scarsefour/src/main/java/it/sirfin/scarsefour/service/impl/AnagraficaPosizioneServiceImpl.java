package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaCasseDto;
import it.sirfin.scarsefour.dto.ListaPosizioniDto;
import it.sirfin.scarsefour.model.Posizione;
import it.sirfin.scarsefour.repository.PosizioneRepository;
import it.sirfin.scarsefour.service.AnagraficaPosizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AnagraficaPosizioneServiceImpl implements AnagraficaPosizioneService {

    @Autowired
    PosizioneRepository posizioneRepository;

    @Override
    public ListaPosizioniDto aggiungiPosizione(Posizione posizione) {
        posizioneRepository.save(posizione);
        return aggiornaPosizione();
    }

    @Override
    public ListaPosizioniDto aggiornaPosizione() {
        return new ListaPosizioniDto(posizioneRepository.findAll());
    }

    @Override
    public ListaPosizioniDto rimuoviPosizione(Posizione posizione) {
        posizioneRepository.delete(posizione);
        return aggiornaPosizione();
    }

    @Override
    public ListaPosizioniDto modificaPosizione(Posizione posizione) {
        posizioneRepository.modificaPosizione(posizione.getCodice(), posizione.getDescrizione(), posizione.getId());
        return aggiornaPosizione();
    }

    @Override
    public ListaPosizioniDto cercaPosizioneLike(String codice, String descrizione) {
        ListaPosizioniDto dto = new ListaPosizioniDto(
                posizioneRepository.findByCodiceContainsOrDescrizioneContains(codice, descrizione));
        return dto;
    }

}
