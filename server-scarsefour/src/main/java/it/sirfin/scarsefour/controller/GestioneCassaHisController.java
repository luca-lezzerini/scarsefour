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

    //////////////////////////////////LOGICA/////////////////////////////////////
//DATI INVIATI DAL CLIENT CON leggiEan(Scontrino(?id), Prodotto.ean)
//
//DATI RICEVUTI DAL CLIENT IN RITORNO DAL SERVER(Scontrino, RigaScontrino, messaggio)
//
//1)leggi ean (leggi ean significa che il server esegue una query su Db che ritorna il prodotto con l'ean inviato da 
//client)
//
//2)in caso il prodotto con quell'ean non viene trovato il server invia un messaggio di errore (attraverso dto) e il
//processo termina quà.
//
//3)il server controlla se c'è uno scontrino aperto(c'è uno scontrino aperto se il client ne manda uno con id valido
//e non nullo), se non c'è ne crea uno, ne imposta le proprietà e lo salva su DB.(se c'è questa operazione viene saltata).
//
//4)il server esegue una query per trovare se ci sono righe associate allo scontrino.
//(se non trova nulla) => crea una riga, ne associa il prodotto cercato impostando:
//	quantita = 1, 
//	ingnoriamo per ora: MovimentiScaffale.
//poi associa la riga allo scontrino e infine lo salva su db.
//
//(se trova una riga contenente quel prodotto)=> recupera quella riga aggiunge 1 alla quantità e la aggiorna su DB
//
//5)aggiorna il totale scontrino su DB
//
//6)vengono recuperati tutti i dati necessari al client e inviati tramite dto.
    
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
