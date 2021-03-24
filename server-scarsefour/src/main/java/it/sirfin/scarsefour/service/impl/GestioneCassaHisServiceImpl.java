package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Prodotto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;
import it.sirfin.scarsefour.repository.AnagraficaProdottiRepository;
import it.sirfin.scarsefour.repository.RigaRepository;
import it.sirfin.scarsefour.repository.ScontrinoRepository;
import it.sirfin.scarsefour.service.GestioneCassaHisService;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class GestioneCassaHisServiceImpl implements GestioneCassaHisService {

    //crea scontrino
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
    public LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto) {
        Prodotto prodotto = anagraficaProdottiRepository.findByEan(dto.getEanProdotto());
        //stampe di debug
        //leggo se il prodotto è stato trovato o meno su DB
        try {
            System.out.println("prodotto trovato: " + prodotto);
        } catch (Exception e) {
            System.out.println("prodotto: nullo, genera una nullPointerException "
                    + "tentando di stamparlo");
        }
        //////////////////////////////////////////////////////////
        if (prodotto != null) {
            //3)il server controlla se c'è uno scontrino aperto
            Scontrino scontrinoAttuale = creaNuovoScontrino(dto.getScontrino());
            return new LeggiEanResponseDto(scontrinoAttuale, null, "");
        } else {
            return new LeggiEanResponseDto(null, null, "prodotto non trovato");
        }
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

    private void associaScontrinoARigaSco(Scontrino scontrino, RigaScontrino rigaScontrino) {
    }

    private void associaRigaScoAProdotto(RigaScontrino rigaScontrino, Prodotto prodotto) {
    }

    private void aggiornaTotScontrino(Scontrino scontrino, Double prezzo) {
    }

    private Scontrino creaNuovoScontrino(Scontrino scontrino) {

        if (scontrino.getId() == null) {
            //scontrino non presente
            System.out.println("lo scontrino non è presente, lo salvo su DB");
            Scontrino s = new Scontrino(
                    LocalDateTime.now(), 0 + 1, 0.0);
            try {
                s.setNumero(scontrinoRepository.trovaUltimoScontrino());
            } catch (Exception e) {
                s.setNumero(1);
            }
            s = scontrinoRepository.save(s);
            System.out.println("scontrino salvato: " + s);
            return s;
        } else if (scontrino.getId() != null) {
            //scontrino presente
            System.out.println("lo scontrino di id: " + scontrino.getId() + "è già presente su DB");
            scontrino = scontrinoRepository.findById(scontrino.getId()).get();
            return scontrino;
        } else {
            System.out.println("errore scontrino");
            throw new RuntimeException("id scontrino non valorizzato, non nullo????");
        }
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
        Scontrino s = new Scontrino();

        creaNuovoScontrino(s);

    }

}
