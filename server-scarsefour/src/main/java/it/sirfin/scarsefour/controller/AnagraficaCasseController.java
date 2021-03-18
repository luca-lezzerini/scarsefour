package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.CassaDto;
import it.sirfin.scarsefour.dto.ListaCasseDto;
import it.sirfin.scarsefour.dto.RicercaPreCriterioDto;
import it.sirfin.scarsefour.service.AnagraficaCasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AnagraficaCasseController {

    @Autowired
    AnagraficaCasseService anagraficaCasseService;

    @RequestMapping("/aggiungi-cassa")
    @ResponseBody
    public ListaCasseDto aggiungiCassa(@RequestBody CassaDto dto) {
        return anagraficaCasseService.aggiungiCassa(dto.getCassa());
    }

    @RequestMapping("/aggiorna-cassa")
    @ResponseBody
    public ListaCasseDto aggiornaCassa() {
    return anagraficaCasseService.aggiornaCassa();
    }
    
     @RequestMapping("/rimuovi-cassa")
    @ResponseBody
    public ListaCasseDto rimuoviCassa(@RequestBody CassaDto dto) {
        return anagraficaCasseService.rimuoviCassa(dto.getCassa());
    }
    
    @RequestMapping("/modifica-cassa")
    @ResponseBody
    public ListaCasseDto modificaCassa(@RequestBody CassaDto dto) {
        return anagraficaCasseService.modificaCassa(dto.getCassa());
    }
    
    @RequestMapping("/cerca-cassa-codice-like")
    @ResponseBody
    public ListaCasseDto cercaCassaLike(@RequestBody RicercaPreCriterioDto dto) {
        return anagraficaCasseService.cercaCassaLike(dto.getCriterioRicerca());
    }
    
}
