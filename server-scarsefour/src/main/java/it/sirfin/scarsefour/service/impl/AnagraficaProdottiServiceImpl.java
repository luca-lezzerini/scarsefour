package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Cassiera;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.service.AnagraficaProdottiService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaProdottiServiceImpl implements AnagraficaProdottiService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;

    /**
     * Questo metodo inserisce un prodotto nel DB
     *
     * @param p è un parametro di tipo prodotto
     * @return ci ritorna una lista aggiornata di prodotti dal DB
     */
    @Override
    public ListaProdottiDto aggiungiProdotto(Prodotto p) {
        anagraficaProdottiRepository.save(p);
        return aggiornaProdotti();
    }

    /**
     * Il metodo rimuove un prodotto da DB
     *
     * @param p è un parametro di tipo Prodotto
     * @return lista aggiornata del db
     */
    @Override
    public ListaProdottiDto rimuoviProdotto(Prodotto p) {
        anagraficaProdottiRepository.delete(p);
        return aggiornaProdotti();
    }

    /**
     * Questo metodo ci fa una ricerca per codice da DB per chiave parziale
     *
     * @param p il parametro è una semplice stringa
     * @return ci ritorna il dto contenente la lista di prodotti con
     * l'aggiornamento al criterio di ricerca
     */
    @Override
    public ListaProdottiDto ricercaProdotto(String p) {
        return new ListaProdottiDto(anagraficaProdottiRepository.trovaProdottoPerCodice(p));
    }

    @Override
    public ListaProdottiDto modificaProdotto(Prodotto p) {
        anagraficaProdottiRepository.save(p);
        return aggiornaProdotti();
    }

    /**
     * Questo metodo ci permette di salvare su Db un oggetto di tipo prodotto
     *
     * @param p il parametro è di tipo Prodotto
     * @return ci ritorna la lista di prodotti aggiornata
     */
    @Override
    public ListaProdottiDto confermaProdotto(Prodotto p) {
        anagraficaProdottiRepository.save(p);
        return aggiornaProdotti();
    }

    /**
     * Questo metodo ci permette di avere una lista di prodotti aggiornata da DB
     *
     * @return ci ritorna un dto con la lista aggiornata all'interno
     */
    @Override
    public ListaProdottiDto aggiornaProdotti() {
        List<Prodotto> lista = anagraficaProdottiRepository.findAll();
        return new ListaProdottiDto(lista);
    }

}
