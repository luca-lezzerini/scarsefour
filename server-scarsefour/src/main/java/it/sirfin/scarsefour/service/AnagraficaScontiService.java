/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ListaScontiDto;
import it.sirfin.scarsefour.dto.ScontiDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.Sconto;

/**
 *
 * @author Userù
 */
public interface AnagraficaScontiService {
    
    ListaScontiDto aggiungiProdottoScontato(Sconto s);
    
    ListaScontiDto rimuoviProdottoScontato(Sconto s);

    ListaScontiDto ricercaProdottoScontato(String s);

    ScontiDto modificaProdottoScontato(Sconto s);

    ListaScontiDto confermaProdottoScontato(Sconto s);

    ListaScontiDto aggiornaProdottiScontati();
    
}
