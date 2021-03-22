/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.service.DashboardCassaGalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardCassaGalServiceImpl implements DashboardCassaGalService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    @Override
    public ProdottoDto verificaEan(String ean) {
        return new ProdottoDto(anagraficaProdottiRepository.findByEan(ean));
    }

}
