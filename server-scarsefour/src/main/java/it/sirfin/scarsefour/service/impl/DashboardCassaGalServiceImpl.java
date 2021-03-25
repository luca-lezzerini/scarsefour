/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.dto.ScontrinoClientGalDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.ProdottoRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.DashboardCassaGalService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardCassaGalServiceImpl implements DashboardCassaGalService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;
    @Autowired
    ScontrinoRepository scontrinoRepository;
    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    RigaRepository rigaRepository;

    public void demo() {

        Scontrino sc = new Scontrino(LocalDateTime.of(5, Month.MARCH, 2018, 19, 50), 2, 0.0);
        Scontrino sc1 = new Scontrino(LocalDateTime.of(6, Month.JULY, 2015, 13, 35), 3, 0.0);
        Scontrino sc2 = new Scontrino(LocalDateTime.of(2, Month.MARCH, 2012, 16, 20), 4, 0.0);

        sc = scontrinoRepository.save(sc);
        sc1 = scontrinoRepository.save(sc1);
        sc2 = scontrinoRepository.save(sc2);

    }

    @Override
    public ScontrinoClientGalDto verificaEan(String ean, Scontrino sc) {
        // cerco il prodotto per EAN
        Prodotto prod = anagraficaProdottiRepository.findByEan(ean);
        // se lo trovo ok ...
        if (prod == null) {
            // .. se non lo trovo  ritorno errore
            return new ScontrinoClientGalDto (null, null, "prodotto non trovato");
        }
        // se lo trovo proseguo per aggiungerlo allo scontrino ...
        // ma lo scontrino esiste? verifico
        if (sc != null) {
            sc = scontrinoRepository.findById(sc.getId()).get();
            return new ScontrinoClientGalDto(null, null, "prodotto trovato");
        }
        // scontrino  non trovato, lo creo
        if (sc == null) {
            sc = new Scontrino();
            sc = scontrinoRepository.save(sc);
        }
        // scontrino trovato, procedo 
        // aggiungo una nuova riga allo scontrino
        RigaScontrino riga = new RigaScontrino();
        riga = rigaRepository.save(riga);
        riga.setProdotto(prod);
        riga.setScontrino(sc);
        riga = rigaRepository.save(riga);
        sc.getRigheScontrino().add(riga);
        sc = scontrinoRepository.save(sc);

        // preparo il DTO di ritorno e finisco
        ScontrinoClientGalDto risp = new ScontrinoClientGalDto();

       // risp.setRigheScontrino(.findById(prod.getId()));
        risp.setScontrino(sc);
        risp.setMessaggio("scontrino pronto!");

        return risp;
    }

    private void associaProdottoARigaScontrino(Prodotto p, RigaScontrino rs) {
        rs.setProdotto(p);
        rigaRepository.save(rs);

        List<RigaScontrino> lista = p.getRigheScontrini();
        lista.add(rs);
        prodottoRepository.save(p);

    }

    private void associaRigaScontrinoAScontrino(RigaScontrino rs, Scontrino s) {
        rs.setScontrino(s);
        rigaRepository.save(rs);

        Set<RigaScontrino> lista = s.getRigheScontrino();
        lista.add(rs);
        scontrinoRepository.save(s);
    }

}
