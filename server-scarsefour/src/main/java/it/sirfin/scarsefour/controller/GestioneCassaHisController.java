/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.EanDtoHis;
import it.sirfin.scarsefour.dto.ProdottoDto;
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
    public ProdottoDto verificaEan(@RequestBody EanDtoHis dto) {
        return gestioneCassaHisService.verificaEan(dto.getBarcode());
    }

    @RequestMapping("salva-scontrino")
    @ResponseBody
    public CreaScontrinoDto salvaScontrino(@RequestBody CreaScontrinoDto dto) {
        return gestioneCassaHisService.salvaScontrino(dto.getScontrino());
    }
    
    @RequestMapping("salva-riga")
    @ResponseBody
    public CreaRigaDto salvaRiga(@RequestBody CreaRigaDto dto) {
       return gestioneCassaHisService.salvaRiga(dto.getRiga());
    }
}
