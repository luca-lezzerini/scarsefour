package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.service.AnagraficaProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AnagraficaProdottiController {

    @Autowired
    AnagraficaProdottiService anagraficaProdottiService;

    @RequestMapping("/aggiungi-prodotto")
    @ResponseBody
    public void aggiungiProdotto() {

    }

    @RequestMapping("/rimuovi-prodotto")
    @ResponseBody
    public void rimuoviProdotto() {

    }

    @RequestMapping("/ricerca-prodotto")
    @ResponseBody
    public void ricercaProdotto() {

    }

    @RequestMapping("/modifica-prodotto")
    @ResponseBody
    public void modificaProdotto() {

    }

    @RequestMapping("/conferma-mod-prodotto")
    @ResponseBody
    public void confermaModificaProdotto() {

    }

}
