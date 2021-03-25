/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.RigaScontrinoClientMacDto;
import it.sirfin.scarsefour.dto.ScontrinoClientMacDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.AnagraficaScontiRepository;
import it.sirfin.scarsefour.repository.CassaMacRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.DashBoardCassaMacService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    public ScontrinoClientMacDto leggiEan(String ean,Scontrino scon) {
        //cerchiamo il prodotto dato l'ean
        Prodotto p = anagraficaProdottiRepository.findByEan(ean);
        //se non troviamo il prodotto rimandiamo un errore 
        if (p == null) {
            return new ScontrinoClientMacDto(null, null, "errore prodotto non trovato");
        }
        //se troviamo il prodotto andiamo ad aggiungere una riga allo scontrino
        //recuperiamo lo scontrino dal DB
//        Scontrino sc = scon.getScontrino();
        if (scon != null) {
           scon = scontrinoRepository.findById(scon.getId()).get();
        }

        //se non esiste lo creiamo nuovo 
        if (scon == null) {
            scon = new Scontrino();
            scon = scontrinoRepository.save(scon);
        }

        //creiamo una nuova riga e lo aggiungiamo allo scontrino e al prodotto
        RigaScontrino riga = new RigaScontrino();
        riga = rigaRepository.save(riga);
        riga.setProdotto(p);
        riga.setScontrino(scon);
        riga = rigaRepository.save(riga);
        // associo lato scontrino
        scon.getRigheScontrino().add(riga);
        scon = scontrinoRepository.save(scon);

//        // associo lato prodotto
//        p.getRigheScontrini().add(riga);
//        p = anagraficaProdottiRepository.save(p);

        //creiamo un dto di ritorno
        ScontrinoClientMacDto risp = new ScontrinoClientMacDto();
        Set<RigaScontrino> righe = scon.getRigheScontrino();
        List<RigaScontrinoClientMacDto> righeDto = new ArrayList<>();
        // TODO:

        righe.forEach(rr
                -> righeDto.add(
                        new RigaScontrinoClientMacDto(
                                rr.getId(),
                                rr.getScontrino().getId(),
                                p.getId(),
                                rr.getProdotto().getDescrizione(),
                                rr.getProdotto().getPrezzo())));

        risp.setRigheScontrino(righeDto);
        risp.setScontrino(scon);
        risp.setMessaggio("scontrino pronto!");

        //ci va scontrino e righe scontrino
        //sc.getRigheScontrino();
        return risp;
    }

}
