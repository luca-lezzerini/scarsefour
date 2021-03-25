/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseMacDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.AnagraficaScontiRepository;
import it.sirfin.scarsefour.repository.CassaMacRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
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
    ScontrinoRepository scontrinoRepository;
    @Autowired
    RigaRepository rigaRepository;
    @Autowired
    CassaMacRepository cassaMacRepository;
    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    @Override
    public LeggiEanResponseMacDto leggiEan(LeggiEanRequestDto dto) {
        //cerchiamo il prodotto dato l'ean
        Prodotto p = anagraficaProdottiRepository.findByEan(dto.getEanProdotto());
        //se non troviamo il prodotto rimandiamo un errore 
        if (p == null) {
            return new LeggiEanResponseMacDto(null, null, "errore prodotto non trovato");
        }
        //se troviamo il prodotto andiamo ad aggiungere una riga allo scontrino
        //recuperiamo lo scontrino dal DB
        Scontrino sc = dto.getScontrino();
        if (sc != null) {
            sc = scontrinoRepository.findById(sc.getId()).get();
        }

        //se non esiste lo creiamo nuovo 
        if (sc == null) {
            sc = new Scontrino();
            sc = scontrinoRepository.save(sc);
        }

        //creiamo una nuova riga e lo aggiungiamo allo scontrino e al prodotto
        RigaScontrino riga = new RigaScontrino();
        riga = rigaRepository.save(riga);
        riga.setProdotto(p);
        riga.setScontrino(sc);
        riga = rigaRepository.save(riga);
        // associo lato scontrino
        sc.getRigheScontrino().add(riga);
        sc = scontrinoRepository.save(sc);

        // associo lato prodotto
        p.getRigheScontrini().add(riga);
        p = anagraficaProdottiRepository.save(p);

        //creiamo un dto di ritorno
        LeggiEanResponseMacDto risp = new LeggiEanResponseMacDto();
        // TODO:
        //ci va scontrino e righe scontrino
        sc.getRigheScontrino();

        return risp;
    }

}