package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Prodotto;

public interface AnagraficaProdottiService {

    ListaProdottiDto aggiungiProdotto(Prodotto p);

    ListaProdottiDto rimuoviProdotto(Prodotto p);

    ListaProdottiDto ricercaProdotto(String p);

    ProdottoDto modificaProdotto(Prodotto p);

    ListaProdottiDto confermaProdotto(Prodotto p);

    ListaProdottiDto aggiornaProdotti();
    
  
}
