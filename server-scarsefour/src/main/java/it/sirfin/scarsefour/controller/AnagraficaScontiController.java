/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ListaScontiDto;
import it.sirfin.scarsefour.dto.RicercaScontiDto;
import it.sirfin.scarsefour.dto.ScontiDto;
import it.sirfin.scarsefour.service.AnagraficaScontiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Userù
 */


@CrossOrigin("*")
@RestController
public class AnagraficaScontiController {
    
    
    @Autowired
    AnagraficaScontiService anagraficaScontiService;

    @RequestMapping("/aggiungi-prodotto-scontato")
    @ResponseBody
    public ListaScontiDto aggiungiProdottoScontato(@RequestBody ScontiDto dto) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + dto);
        return anagraficaScontiService.aggiungiProdottoScontato(dto.getSconto());

    }

    @RequestMapping("/rimuovi-prodotto-scontato")
    @ResponseBody
    public ListaScontiDto rimuoviProdottoScontato(@RequestBody ScontiDto dto) {
        return anagraficaScontiService.rimuoviProdottoScontato(dto.getSconto());
    }

    @RequestMapping("/ricerca-prodotto-scontato")
    @ResponseBody
    public ListaScontiDto ricercaProdottoScontato(@RequestBody RicercaScontiDto dto) {
        return anagraficaScontiService.ricercaProdottoScontato(dto.getRicercaPerCodice());
    }


    @RequestMapping("/modifica-prodotto-scontato")
    @ResponseBody
    public ScontiDto modificaProdottoScontato(@RequestBody ScontiDto dto) {
        return anagraficaScontiService.modificaProdottoScontato(dto.getSconto());
    }
    
    
    @RequestMapping("/aggiorna-prodotto-scontato")
    @ResponseBody
    public ListaScontiDto aggiornaProdottoScontato() {
    return anagraficaScontiService.aggiornaProdottiScontati();
    }
    
    
}
