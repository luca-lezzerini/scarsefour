/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.dto.RigaScontrinoClientDto;
import it.sirfin.scarsefour.dto.RigaScontrinoClientGalDto;
import it.sirfin.scarsefour.dto.ScontrinoClientGalDto;
import it.sirfin.scarsefour.dto.ScontrinoDtoIll;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.ProdottoRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.DashboardCassaIllService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardCassaIllServiceImpl implements DashboardCassaIllService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;
    @Autowired
    ScontrinoRepository scontrinoRepository;
    @Autowired
    RigaRepository rigaRepository;
    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public void test() {
        Scontrino s1 = new Scontrino(LocalDateTime.now(), 1, 150.67);
        s1 = scontrinoRepository.save(s1);
        Scontrino s2 = new Scontrino(LocalDateTime.now(), 2, 22.80);
        s2 = scontrinoRepository.save(s2);
        Scontrino s3 = new Scontrino(LocalDateTime.now(), 3, 77.00);
        s3 = scontrinoRepository.save(s3);
    }

    @Override
    public ScontrinoDtoIll trovaEan(String ean, Scontrino sc) {
        //Nel dto request mi arriva l'ean del prodotto, tramite query interrogo
        //il db e trovo o il prodotto che ha quel ena (codice a barre),
        //oppure devo spedire un messaggio di errore
        Prodotto p = anagraficaProdottiRepository.findByEan(ean);
        if (p == null) {
            //se non è stato trovato alcun prodotto recupero il dto e
            //spedisco un messaggio di errore
            return new ScontrinoDtoIll(null, null, "prodotto non trovato");
        }
        //se invece è stato trovato un prodotto devo associarlo alla
        //riga scontrino che è a sua volta associata ad uno scontrino
        // quindi recupero lo scontrino ...
        if (sc != null) {
            sc = scontrinoRepository.findById(sc.getId()).get();
            //return new ScontrinoDtoIll(null, null, "prodotto trovato");
        }
        // se non esiste lo scontrino lo creo ...
        if (sc == null) {
            sc = new Scontrino();
            sc = scontrinoRepository.save(sc);
        }

        // creo la riga e la salvo ...
        RigaScontrino r = new RigaScontrino();
        r = rigaRepository.save(r);
        r.setProdotto(p);
        r.setScontrino(sc);
        r = rigaRepository.save(r);

        // aggiungo la riga allo scontrino
        sc.getRigheScontrino().add(r);
        sc = scontrinoRepository.save(sc);

        // creo il DTO con i dati da ritornare al client
        ScontrinoDtoIll risp = new ScontrinoDtoIll();
        Set<RigaScontrino> righe = sc.getRigheScontrino();
        List<RigaScontrinoClientDto> righeDto = new ArrayList<>();
        // trasformo le righe originali dello scontrino in righe del DTO
        righe.forEach(rr
                -> righeDto.add(
                        new RigaScontrinoClientDto(
                                rr.getId(),
                                rr.getScontrino().getId(),
                                p.getId(),
                                rr.getProdotto().getDescrizione(),
                                rr.getProdotto().getPrezzo())));

        risp.setRigheScontrino(righeDto);
        risp.setScontrino(sc);
        risp.setMessaggio("scontrino pronto!");

        return risp;
    }

    //Verificare se c'è uno scontrino aperto e associato, se non c'è occorre 
    //crearlo e associarlo alla rigascontrino
    private Scontrino creaScont(Scontrino sc) {
        //verificare se lo scontrino è valido
        if (sc.getId() == null) {
            Scontrino nuovoScontrino = new Scontrino(LocalDateTime.now(),
                    0 + 1, 0.0);
            nuovoScontrino.setNumero(1);
            scontrinoRepository.save(nuovoScontrino);
            return nuovoScontrino;
        }
        return sc;
    }

    public CreaRigaDto creaRiga(RigaScontrino rs) {
        rs = rigaRepository.save(rs);
        return new CreaRigaDto(rs);
    }

    private void associaProdottoARigaScontrino(Prodotto prod, RigaScontrino rs) {
        rs.setProdotto(prod);
        rigaRepository.save(rs);

        List<RigaScontrino> lista = prod.getRigheScontrini();
        lista.add(rs);
        prodottoRepository.save(prod);
    }

    private void associaRigaScontrinoAScontrino(RigaScontrino rs, Scontrino scont) {
        rs.setScontrino(scont);
        rigaRepository.save(rs);

        Set<RigaScontrino> lista1 = scont.getRigheScontrino();
        lista1.add(rs);
        scontrinoRepository.save(scont);
    }

}
