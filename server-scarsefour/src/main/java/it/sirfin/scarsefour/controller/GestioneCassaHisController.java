/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.AnnullaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.service.GestioneCassaHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class GestioneCassaHisController {

    @Autowired
    GestioneCassaHisService gestioneCassaHisService;

    @RequestMapping("verifica-ean")
    @ResponseBody
    public LeggiEanResponseDto verificaEan(@RequestBody LeggiEanRequestDto dto) {
        try {
            System.out.println("Scontrino ricevuto da client: " + dto.getScontrino());
        } catch (Exception e) {
            System.out.println("Scontrino: nullo, genera una nullPointerException "
                    + "tentando di stamparlo");
        }
        System.out.println("Ean prodotto ricevuto da client: " + dto.getEanProdotto());
        return gestioneCassaHisService.leggiEan(dto);
    }

    @RequestMapping("annulla-scontrino")
    @ResponseBody
    public AnnullaScontrinoDto annullaScontrino(@RequestBody AnnullaScontrinoDto dto) {
        System.out.println("siamo nel controller di annullaScontrino");
        return gestioneCassaHisService.annullaScontrino(dto.getScontrino(),dto.getRigheScontrino());
    }

    @RequestMapping("demoAssociaScontrinoARigaSco")
    private void demoAssociaScontrinoARigaSco() {
        gestioneCassaHisService.demoAssociaScontrinoARigaSco();
    }

    @RequestMapping("demoAssociaRigaScoAProdotto")
    private void demoAssociaRigaScoAProdotto() {
        gestioneCassaHisService.demoAssociaRigaScoAProdotto();
    }

    @RequestMapping("demoAggiornaTotScontrino")
    private void demoAggiornaTotScontrino() {
        gestioneCassaHisService.demoAggiornaTotScontrino();
    }

    @RequestMapping("demoCreaNuovoScontrino")
    private void demoCreaNuovoScontrino() {

        gestioneCassaHisService.demoCreaNuovoScontrino();
    }
}
