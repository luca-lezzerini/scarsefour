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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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

    private void associaScontrinoARigaSco(Scontrino s, RigaScontrino rs) {
        //associo riga a scontrino
        rs.setScontrino(s);
        rigaRepository.save(rs);
        //associo scontrino a riga
        Set<RigaScontrino> rr = s.getRigheScontrino();
        rr.add(rs);
        scontrinoRepository.save(s);

    }

    private void associaRigaScoAProdotto(RigaScontrino rs, Prodotto p) {
        

        rs.setProdotto(p);
        rigaRepository.save(rs);
        Set<Prodotto> pro = (Set<Prodotto>) rs.getProdotto();
        pro.add(p);
        anagraficaProdottiRepository.save(p);
    }

    private void aggiornaTotScontrino(Scontrino scontrino, Double prezzo) {
    }

    private Scontrino creaNuovoScontrino() {
        Scontrino scontrino = new Scontrino();
        return scontrino;
    }

    @Override
    public void demoAssociaScontrinoARigaSco() {

        Scontrino s1 = new Scontrino(LocalDateTime.now(), 2, 7.5);
        s1 = scontrinoRepository.save(s1);
        Scontrino s2 = new Scontrino(LocalDateTime.now(), 5, 10.0);
        s2 = scontrinoRepository.save(s2);
        RigaScontrino rs1 = new RigaScontrino(100);
        rs1 = rigaRepository.save(rs1);
        RigaScontrino rs2 = new RigaScontrino(35);
        rs2 = rigaRepository.save(rs2);
        associaScontrinoARigaSco(s1, rs2);
        associaScontrinoARigaSco(s2, rs1);

    }

    @Override
    public void demoAssociaRigaScoAProdotto() {
        
        RigaScontrino rs2 = new RigaScontrino(35);
        rs2 = rigaRepository.save(rs2);
        RigaScontrino rs1 = new RigaScontrino(100);
        rs1 = rigaRepository.save(rs1);
        Prodotto p1 = new Prodotto();
        p1 = anagraficaProdottiRepository.save(p1);
        Prodotto p2 = new Prodotto();
        p2 = anagraficaProdottiRepository.save(p2);
        associaRigaScoAProdotto(rs1, p2);
        associaRigaScoAProdotto(rs2, p1);
        
    }

    @Override
    public void demoAggiornaTotScontrino() {
    }

    @Override
    public void demoCreaNuovoScontrino() {
    }

}
