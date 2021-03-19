package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ListaPosizioniDto;
import it.sirfin.scarsefour.dto.PosizioneDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AnagraficaPosizioneController {
    
    @RequestMapping("aggiungi-posizione")
    @ResponseBody
    public ListaPosizioniDto aggiungi(@RequestBody PosizioneDto dto){
        throw new UnsupportedOperationException();
    }
    @RequestMapping("rimuovi-posizione")
    @ResponseBody
    public ListaPosizioniDto rimuovi(@RequestBody PosizioneDto dto){
        throw new UnsupportedOperationException();
    }
    @RequestMapping("modifica-posizione")
    @ResponseBody
    public ListaPosizioniDto modifica(@RequestBody PosizioneDto dto){
        throw new UnsupportedOperationException();
    }
    @RequestMapping("ricerca-posizione")
    @ResponseBody
    public ListaPosizioniDto ricerca(@RequestBody PosizioneDto dto){
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping("aggiorna-posizione")
    @ResponseBody
    public ListaPosizioniDto aggiorna(@RequestBody PosizioneDto dto){
        throw new UnsupportedOperationException();
    }
}
