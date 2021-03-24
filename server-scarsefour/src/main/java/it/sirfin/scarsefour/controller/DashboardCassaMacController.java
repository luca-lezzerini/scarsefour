/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.RicercaProdottoDto;
import it.sirfin.scarsefour.service.DashBoardCassaMacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@CrossOrigin("*")
public class DashboardCassaMacController {

    @Autowired
    DashBoardCassaMacService dashBoardCassaMacService;

    @RequestMapping("ricerca-prodotto-mac")
    @ResponseBody
    public ListaProdottiDto leggiProdottoMac(@RequestBody RicercaProdottoDto prodotto) {
        return dashBoardCassaMacService.ricercaProdotto(prodotto.getRicercaPerCodice());
    }

}
