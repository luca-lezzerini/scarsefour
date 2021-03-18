package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaCasseDto;
import it.sirfin.scarsefour.model.Cassa;
import it.sirfin.scarsefour.repository.CassaRepository;
import it.sirfin.scarsefour.service.AnagraficaCasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaCasseServiceImpl implements AnagraficaCasseService {

    @Autowired
    CassaRepository cassaRepository;

    @Override
    public ListaCasseDto aggiungiCassa(Cassa cassa) {
        cassaRepository.save(cassa);
        return aggiornaCassa();
    }

    @Override
    public ListaCasseDto aggiornaCassa() {
        return new ListaCasseDto(cassaRepository.findAll());
    }

    @Override
    public ListaCasseDto rimuoviCassa(Cassa cassa) {
        cassaRepository.delete(cassa);
        return aggiornaCassa();
    }

}
