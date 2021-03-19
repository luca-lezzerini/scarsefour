package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.CassieraDto;
import it.sirfin.scarsefour.dto.ListaCassiereDto;
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
    public ListaCassiereDto aggiungiCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.aggiungiCassiera(dto.getCassiera());
    }

    @RequestMapping("/rim-cassiera")
    @ResponseBody
    public ListaCassiereDto rimuoviCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.rimuoviCassiera(dto.getCassiera());
    }

    @RequestMapping("/ric-cassiera")
    @ResponseBody
    public ListaCassiereDto ricercaCassiera(@RequestBody RicercaCassieraDto dto) {
        return anagraficaCassiereService.ricercaCassiera(dto.getCriterioRicerca());
    }

    @RequestMapping("/conf-cassiera")
    @ResponseBody
    public ListaCassiereDto confermaModificaCassiera(@RequestBody CassieraDto dto) {
        return anagraficaCassiereService.confermaModifica(dto.getCassiera());
    }
    
    @RequestMapping("/aggiorna-cassieri")
    @ResponseBody
    public ListaCassiereDto aggiornaCassieri() {
        return anagraficaCassiereService.aggiornaCassieri();
    }

}
