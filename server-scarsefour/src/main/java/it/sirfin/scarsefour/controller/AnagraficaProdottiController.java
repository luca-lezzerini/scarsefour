package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.service.AnagraficaProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ListaProdottiDto aggiungiProdotto(@RequestBody ProdottoDto dto) {
        return anagraficaProdottiService.aggiungiProdotto(dto.getProdotto());
     
    }

    /**
     * Questo metodo rimuove un prodotto dal database
     * @param  Riceviamo un dto che contiene un PRODOTTO
     * @return lista aggiornata della tabella "Prodotti" ps. I galli so passati pe primi
     * 
     */
    @RequestMapping("/rimuovi-prodotto")
    @ResponseBody
    public ListaProdottiDto rimuoviProdotto(@RequestBody ProdottoDto dto) {
      return anagraficaProdottiService.rimuoviProdotto(dto.getProdotto());
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
