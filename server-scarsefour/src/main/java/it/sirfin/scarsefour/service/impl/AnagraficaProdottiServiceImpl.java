package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.service.AnagraficaProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaProdottiServiceImpl implements AnagraficaProdottiService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    @Override
    public ListaProdottiDto aggiungiProdotto(Prodotto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaProdottiDto rimuoviProdotto(Prodotto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaProdottiDto ricercaProdotto(Prodotto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdottoDto modificaProdotto(Prodotto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaProdottiDto confermaProdotto(Prodotto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
