package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassiereDto;
import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.repository.AnagraficaCassiereRepository;
import it.sirfin.scarsefour.service.AnagraficaCassiereService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaCassiereServiceImpl implements AnagraficaCassiereService {

    @Autowired
    AnagraficaCassiereRepository anagraficaCassiereRepository;

    @Override
    public ListaCassiereDto aggiungiCassiera(Cassiera cas) {
        anagraficaCassiereRepository.save(cas);
        return aggiornaCassieri();
    }

    @Override
    public ListaCassiereDto rimuoviCassiera(Cassiera cas) {
        anagraficaCassiereRepository.delete(cas);
        return aggiornaCassieri();
    }

    @Override
    public ListaCassiereDto ricercaCassiera(String c) {
        List<Cassiera> lista = anagraficaCassiereRepository.trovaCassieraPerCognome(c);
        return new ListaCassiereDto(lista);
    }

    @Override
    public CassieraDto modificaCassiera(Cassiera cas) {
        return new CassieraDto(cas);
    }

    @Override
    public ListaCassiereDto confermaModifica(Cassiera cas) {
        anagraficaCassiereRepository.save(cas);
        return aggiornaCassieri();
    }

    @Override
    public ListaCassiereDto aggiornaCassieri() {
        List<Cassiera> lista = anagraficaCassiereRepository.findAll();
        return new ListaCassiereDto(lista);
    }

}
