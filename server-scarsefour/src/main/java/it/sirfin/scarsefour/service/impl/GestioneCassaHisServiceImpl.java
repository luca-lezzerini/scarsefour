package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.GestioneCassaHisService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class GestioneCassaHisServiceImpl implements GestioneCassaHisService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;
    @Autowired
    ScontrinoRepository scontrinoRepository;

    @Override
    public ProdottoDto verificaEan(String barcode) {
        return new ProdottoDto(anagraficaProdottiRepository.findByEan(barcode));
    }

    @Override
    public CreaScontrinoDto salvaScontrino(Scontrino scontrino) {
        scontrino = scontrinoRepository.save(scontrino);
        return new CreaScontrinoDto(scontrino);
    }

}
