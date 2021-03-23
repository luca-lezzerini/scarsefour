/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.DashboardCassaIllService;
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

    @Override
    public ProdottoDto trovaEan(String ean) {
        return new ProdottoDto(anagraficaProdottiRepository.findByEan(ean));
    }

    @Override
    public CreaScontrinoDto creaScont(Scontrino sc) {
        sc = scontrinoRepository.save(sc);
        return new CreaScontrinoDto(sc);
    }

    @Override
    public CreaRigaDto creaRiga(RigaScontrino rs) {
        rs = rigaRepository.save(rs);
        return new CreaRigaDto(rs);
    }

}
