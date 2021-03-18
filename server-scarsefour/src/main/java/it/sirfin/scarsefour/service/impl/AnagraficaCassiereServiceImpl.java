package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassieriDto;
import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.repository.AnagraficaCassiereRepository;
import it.sirfin.scarsefour.service.AnagraficaCassiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaCassiereServiceImpl implements AnagraficaCassiereService {

    @Autowired
    AnagraficaCassiereRepository anagraficaCassiereRepository;

    @Override
    public ListaCassieriDto aggiungiCassiera(Cassiera cas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaCassieriDto rimuoviCassiera(Cassiera cas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaCassieriDto ricercaCassiera(String c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CassieraDto modificaCassiera(Cassiera cas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaCassieriDto confermaModifica(Cassiera cas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
