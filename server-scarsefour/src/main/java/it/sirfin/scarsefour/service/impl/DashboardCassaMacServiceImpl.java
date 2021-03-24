/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.model.Prodotto;
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

    @Override
    public ListaProdottiDto ricercaProdotto(String barcode) { //metodo client:  ricercaEan(), riga 249
        return new ListaProdottiDto(cassaMacRepository.findByEan(barcode));
    }

}
