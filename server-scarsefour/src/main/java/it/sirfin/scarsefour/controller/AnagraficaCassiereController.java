package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.service.AnagraficaCassiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public void aggiungiCassiera() {

    }

    @RequestMapping("/rim-cassiera")
    @ResponseBody
    public void rimuoviCassiera() {

    }

    @RequestMapping("/ric-cassiera")
    @ResponseBody
    public void ricercaCassiera() {

    }

    @RequestMapping("/mod-cassiera")
    @ResponseBody
    public void modificaCassiera() {

    }

    @RequestMapping("/conf-cassiera")
    @ResponseBody
    public void confermaModificaCassiera() {

    }

}
