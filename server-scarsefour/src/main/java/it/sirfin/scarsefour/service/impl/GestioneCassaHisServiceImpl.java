package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.GestioneCassaHisService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class GestioneCassaHisServiceImpl implements GestioneCassaHisService {

    @Autowired
    AnagraficaProdottiRepository anagraficaProdottiRepository;
    @Autowired
    ScontrinoRepository scontrinoRepository;
    @Autowired
    RigaRepository rigaRepository;

    @Override
    public ProdottoDto verificaEan(String barcode) {
        //il server crea un nuovo scontrino se già nn ce n'è uno, e ne imposta la data, il numero

        //controlla se c'è una riga che già continene il prodotto scannerizzato:
        //Se la trova ne aggiorna la quantità.
        //se non la trova crea una riga, le associa il prodotto scannerizzato e associa la riga allo scontrino 
        //aggiornare totale scontrino
        //il server restituisce lo scontrino e la riga creata e associata in precedenza
        Prodotto prodotto = anagraficaProdottiRepository.findByEan(barcode);
        return new ProdottoDto(prodotto);
    }

    @Override
    public CreaScontrinoDto salvaScontrino(Scontrino scontrino) {
        scontrino = scontrinoRepository.save(scontrino);
        return new CreaScontrinoDto(scontrino);
    }

    @Override
    public CreaRigaDto salvaRiga(RigaScontrino riga) {
        System.out.println(riga);
        riga = rigaRepository.save(riga);
        return new CreaRigaDto(riga);
    }

    //
    private void associaScontrinoARigaSco(Scontrino scontrino, RigaScontrino rigaScontrino) {
    }

    private void associaRigaScoAProdotto(RigaScontrino rigaScontrino, Prodotto prodotto) {
    }

    private void aggiornaTotScontrino(Scontrino scontrino, Double prezzo) {
    }

    private Scontrino creaNuovoScontrino() {
        Scontrino scontrino = new Scontrino();
        return scontrino;
    }

    @Override
    public void demoAssociaScontrinoARigaSco() {
    }

    @Override
    public void demoAssociaRigaScoAProdotto() {
    }

    @Override
    public void demoAggiornaTotScontrino() {
    }

    @Override
    public void demoCreaNuovoScontrino() {
    }
}
