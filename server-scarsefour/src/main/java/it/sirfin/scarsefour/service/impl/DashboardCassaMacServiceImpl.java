/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.AnagraficaScontiRepository;
import it.sirfin.scarsefour.repository.CassaMacRepository;
import it.sirfin.scarsefour.service.DashBoardCassaMacService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Transactional
@Service
public class DashboardCassaMacServiceImpl implements DashBoardCassaMacService {

    @Autowired
    AnagraficaScontiRepository anagraficaScontiRepository;
    @Autowired
    CassaMacRepository cassaMacRepository;
    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    @Override
    public LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto) {
        //cerchiamo il prodotto dato l'ean
        Prodotto p = anagraficaProdottiRepository.findByEan(dto.getEanProdotto());
        //se non troviamo il prodotto rimandiamo un errore 
        if (p == null){
        //TODO:
        }
        //se troviamo il prodotto andiamo ad aggiungere una riga allo scontrino
        
        //recuperiamo lo scontrino dal DB
        Scontrino sc = anagraficaScontiRepository.findBy
        //se non esiste lo creiamo nuovo 
        
        //se esiste creiamo una nuova riga e lo aggiungiamo allo scontrino
        
        //creiamo un dto di ritorno
    }

}
