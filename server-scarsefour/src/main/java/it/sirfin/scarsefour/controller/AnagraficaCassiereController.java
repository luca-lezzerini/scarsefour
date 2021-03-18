package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassieriDto;
import it.sirfin.scarsefour.dto.RicercaCassieraDto;
import it.sirfin.scarsefour.service.AnagraficaCassiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AnagraficaCassiereController {

    @Autowired
    AnagraficaCassiereService anagraficaCassiereService;

    @RequestMapping("/add-cassiera")
    @ResponseBody
    public ListaCassieriDto aggiungiCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.aggiungiCassiera(dto.getCassiera());
    }

    @RequestMapping("/rim-cassiera")
    @ResponseBody
    public ListaCassieriDto rimuoviCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.rimuoviCassiera(dto.getCassiera());
    }

    @RequestMapping("/ric-cassiera")
    @ResponseBody
    public ListaCassieriDto ricercaCassiera(@RequestBody RicercaCassieraDto dto) {
        return anagraficaCassiereService.ricercaCassiera(dto.getCriterioRicerca());
    }

    @RequestMapping("/mod-cassiera")
    @ResponseBody
    public CassieraDto modificaCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.modificaCassiera(dto.getCassiera());
    }

    @RequestMapping("/conf-cassiera")
    @ResponseBody
    public ListaCassieriDto confermaModificaCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.confermaModifica(dto.getCassiera());
    }

}
