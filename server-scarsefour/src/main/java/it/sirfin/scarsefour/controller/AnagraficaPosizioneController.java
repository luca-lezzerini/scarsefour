package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ListaPosizioniDto;
import it.sirfin.scarsefour.dto.PosizioneDto;
import it.sirfin.scarsefour.dto.RicercaPreCriterioDto;
import it.sirfin.scarsefour.service.AnagraficaPosizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AnagraficaPosizioneController {

    @Autowired
    AnagraficaPosizioneService anagraficaPosizioneService;

    @RequestMapping("aggiungi-posizione")
    @ResponseBody
    public ListaPosizioniDto aggiungi(@RequestBody PosizioneDto dto) {
        return anagraficaPosizioneService.aggiungiPosizione(dto.getPosizione());
    }

    @RequestMapping("rimuovi-posizione")
    @ResponseBody
    public ListaPosizioniDto rimuovi(@RequestBody PosizioneDto dto) {
        return anagraficaPosizioneService.rimuoviPosizione(dto.getPosizione());
    }

    @RequestMapping("modifica-posizione")
    @ResponseBody
    public ListaPosizioniDto modifica(@RequestBody PosizioneDto dto) {
        return anagraficaPosizioneService.modificaPosizione(dto.getPosizione());
    }

    @RequestMapping("ricerca-posizione")
    @ResponseBody
    public ListaPosizioniDto ricerca(@RequestBody RicercaPreCriterioDto dto) {
        return anagraficaPosizioneService.cercaPosizioneLike(dto.getCriterioRicerca(), dto.getCriterioRicerca());
    }

    @RequestMapping("aggiorna-posizione")
    @ResponseBody
    public ListaPosizioniDto aggiorna() {
        return  anagraficaPosizioneService.aggiornaPosizione();
    }
}
