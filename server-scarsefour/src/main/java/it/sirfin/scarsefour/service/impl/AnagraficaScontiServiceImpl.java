/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaScontiDto;
import it.sirfin.scarsefour.dto.ScontiDto;
import it.sirfin.scarsefour.model.Sconto;
import it.sirfin.scarsefour.repository.AnagraficaScontiRepository;
import it.sirfin.scarsefour.service.AnagraficaScontiService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service 
public class AnagraficaScontiServiceImpl implements AnagraficaScontiService {
    
    @Autowired
    AnagraficaScontiRepository anagraficaScontiRepository;

    @Override
    public ListaScontiDto aggiungiProdottoScontato(Sconto s) {
        anagraficaScontiRepository.save(s);
        return aggiornaProdottiScontati();
    }

    /**
     * Il metodo rimuove un prodotto da DB
     *
     * @param s è un parametro di tipo Sconto
     * @return lista degli sconti aggiornata dal db
     */
    @Override
    public ListaScontiDto rimuoviProdottoScontato(Sconto s) {
        anagraficaScontiRepository.delete(s);
        return aggiornaProdottiScontati();
    }

    @Override
    public ListaScontiDto ricercaProdottoScontato(String s) {
    
    return new ListaScontiDto (anagraficaScontiRepository.findByCodiceContains(s));
    }

    @Override
    public ScontiDto modificaProdottoScontato(Sconto s) {
        return new ScontiDto(s);
    }

    @Override
    public ListaScontiDto confermaProdottoScontato(Sconto s) {
        anagraficaScontiRepository.save(s);
        return aggiornaProdottiScontati();
    }

    @Override
    public ListaScontiDto aggiornaProdottiScontati() {
        List<Sconto> lista = anagraficaScontiRepository.findAll();
        return new ListaScontiDto (new HashSet<Sconto>(anagraficaScontiRepository.findAll()));
    }
    
}
