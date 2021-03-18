package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaCassieriDto;
import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.service.AnagraficaProdottiService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaProdottiServiceImpl implements AnagraficaProdottiService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    @Override
    public ListaProdottiDto aggiungiProdotto(Prodotto p) {
        anagraficaProdottiRepository.save(p);
        return aggiornaProdotti();
    }

    /**
     * Il metodo rimuove un prodotto da DB
     * @param p è un parametro di tipo Prodotto
     * @return lista aggiornata del db
     */
    @Override
    public ListaProdottiDto rimuoviProdotto(Prodotto p) {
        anagraficaProdottiRepository.delete(p);
        return aggiornaProdotti();
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

    @Override
    public ListaProdottiDto aggiornaProdotti() {
        List<Prodotto> lista = anagraficaProdottiRepository.findAll();
        return new ListaProdottiDto((Set<Prodotto>) lista);
    }

}
