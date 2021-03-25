package it.sirfin.scarsefour.service.impl;

import it.sirfin.scarsefour.dto.AnnullaScontrinoDto;
import it.sirfin.scarsefour.dto.LeggiEanRequestDto;
import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.StornaRitornoDto;
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
import java.util.stream.Collectors;
import org.hibernate.engine.profile.Fetch;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
//DATI INVIATI DAL CLIENT CON leggiEan(Scontrino, Prodotto.ean)
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
//4)NO    {{{{{il server esegue una query per trovare se ci sono righe associate allo scontrino.}}}}}
//{{{{{ (se non trova nulla) =>}}}}}} crea una riga, ne associa il prodotto cercato impostando:
//	quantita = 1, 
//	ingnoriamo per ora: MovimentiScaffale.
//poi associa la riga allo scontrino e infine lo salva su db.
//
// NO   {{{{{(se trova una riga contenente quel prodotto)=> recupera quella riga aggiunge 1 alla quantità e la aggiorna su DB}}}
//
//5)aggiorna il totale scontrino su DB
//
//6)vengono recuperati tutti i dati necessari al client e inviati tramite dto.
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public LeggiEanResponseDto leggiEan(LeggiEanRequestDto dto) {
        Prodotto prodotto = anagraficaProdottiRepository.findByEan(dto.getEanProdotto());
        //leggo se il prodotto è stato trovato o meno su DB
        try {
            System.out.println("prodotto trovato: " + prodotto);
        } catch (Exception e) {
            System.out.println("prodotto: nullo, genera una nullPointerException "
                    + "tentando di stamparlo");
        }

        if (prodotto != null) {
            System.out.println("creo un nuovo scontrino se serve");
            Scontrino scontrinoAttuale = creaNuovoScontrino(dto.getScontrino());
            System.out.println("creo una rigaScontrino se serve");
            RigaScontrino nuovaRigaScontrino = creaRigaSemplice(scontrinoAttuale, prodotto);
            System.out.println("aggiorno il totale dello scontrino");
            scontrinoAttuale = aggiornaTotScontrino(scontrinoAttuale, prodotto.getPrezzo());
            System.out.println("scontrino con prezzo aggiornato: " + scontrinoAttuale.getTotale());
            LeggiEanResponseDto responseDto = new LeggiEanResponseDto(scontrinoAttuale, nuovaRigaScontrino, "");
            System.out.println("stiamo per spedire al client i seguenti dati: " + responseDto);
            return responseDto;
        } else {
            return new LeggiEanResponseDto(null, null, "Prodotto sconosciuto");
        }
    }

    /**
     * Questo metodo associa uno Scontrino e una riga scontrino
     *
     * @param s
     * @param rs
     */
    private void associaScontrinoARigaSco(Scontrino s, RigaScontrino rs) {
        System.out.println("siamo in associa riga e scontrino");
        //associo riga a scontrino
        rs.setScontrino(s);
        rigaRepository.save(rs);
        //associo scontrino a riga
        Set<RigaScontrino> rr = s.getRigheScontrino();
        rr.add(rs);
        scontrinoRepository.save(s);
    }

    /**
     * Questo metodo associa una riga scontrino e un prodotto
     *
     * @param rs
     * @param p
     */
    private void associaRigaScoAProdotto(RigaScontrino rs, Prodotto p) {
        System.out.println("siamo in associa riga con prodotto");
        rs.setProdotto(p);
        rigaRepository.save(rs);
        List<RigaScontrino> pro = p.getRigheScontrini();
        pro.add(rs);
        anagraficaProdottiRepository.save(p);
    }

    /**
     * Questo metodo aggiorna il totale scontrino
     *
     * @param scontrino
     * @param prezzo
     * @return
     */
    @Transactional()
    private Scontrino aggiornaTotScontrino(Scontrino scontrino, Double prezzo) {
//        System.out.println("********************Siamo nel metodo aggiornaTotScontrino*******************");
//        System.out.println("stiamo tentando di aggiornare il totale dello scontrino");
//        System.out.println("prezzo da aggiungere: " + prezzo + " scontrino: " + scontrino.getId());
        Double totale = scontrinoRepository.trovaTotale(scontrino.getId());
        totale += prezzo;
        scontrinoRepository.aggiornaTotScontrino(totale, scontrino.getId());
        Scontrino scontrinoAggiornato = scontrinoRepository.findById(scontrino.getId()).get();
//        System.out.println("scontrino aggiornato: " + scontrino.getId() + " totale: " + scontrino.getTotale());
        return scontrinoAggiornato;
    }

    /**
     * riceve tra i parametri uno scontrino, controlla se il suo id 1) se il
     * client ha inviato uno scontrino con id null vuol dire che non c'era uno
     * scontrino aperto, per cui ne creo uno, ne inizializzo le proprietà e lo
     * salvo su DB e lo ritorno. 2) se il client ha inviato uno scontrino con id
     * non null, significa che il client sta lavorando su quello scontrino, per
     * cui lo recupero da DB e lo ritorno.
     *
     * @param scontrino
     * @return
     */
    private Scontrino creaNuovoScontrino(Scontrino scontrino) {

        if (scontrino.getId() == null) {
            //scontrino non presente
            System.out.println("lo scontrino non è presente, lo salvo su DB");
            Scontrino s = new Scontrino(
                    LocalDateTime.now(), 0 + 1, 0.0);
            try {
                s.setNumero(scontrinoRepository.trovaUltimoScontrino() + 1);
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

    /**
     * Crea una riga e ne definisce le associazioni e ritorna la riga
     *
     * @param Scontrino s
     * @param Prodotto p
     * @return riga
     */
    private RigaScontrino creaRigaSemplice(Scontrino s, Prodotto p) {
        RigaScontrino riga = new RigaScontrino();
        riga.setQuantita(1);
        associaRigaScoAProdotto(riga, p);
        associaScontrinoARigaSco(s, riga);
        return riga;
    }

    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////METODI DEMO PER TEST///////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void demoAssociaScontrinoARigaSco() {

        Scontrino s1 = new Scontrino(LocalDateTime.now(), 2, 7.5);
        s1 = scontrinoRepository.save(s1);
        Scontrino s2 = new Scontrino(LocalDateTime.now(), 5, 10.0);
        s2 = scontrinoRepository.save(s2);
        RigaScontrino rs1 = new RigaScontrino();
        rs1 = rigaRepository.save(rs1);
        RigaScontrino rs2 = new RigaScontrino();
        rs2 = rigaRepository.save(rs2);
        associaScontrinoARigaSco(s1, rs2);
        associaScontrinoARigaSco(s2, rs1);

    }

    @Override
    public void demoAssociaRigaScoAProdotto() {

        RigaScontrino rs2 = new RigaScontrino();
        rs2 = rigaRepository.save(rs2);
        RigaScontrino rs1 = new RigaScontrino();
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

    ///////////////////////////////////////////////////////////////////////////
    /////////////////////////////METODI IN DIDUSO///////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Crea uno riga scontrino partendo da uno scontrino e un prodotto; 1) cerco
     * su DB tutte le righe associate allo scontrino 2) se trovo righe associate
     * filtro la lista di righe associate per prodotto, poi: A) se la lista
     * filtrata è vuota vuol dire che quella riga con quel prodotto ancora non
     * esiste per cui ne creo una ne inizializzo le proprietà, ne definisco le
     * associazioni (i metodi associa salvano su DB). B) se la lista contiene un
     * valore vuol dire che c'è una riga con quel prodotto legata allo scontrino
     * attuale per cui non la creo ma la recupero e ne incremento soltanto la
     * quantità poi la salvo su DB
     *
     * 3) se non trovo righe associate ne creo una ne inizializzo le proprietà,
     * ne definisco le associazioni (i metodi associa salvano su DB).
     *
     * @param Sontrino s
     * @param Prodotto p
     *
     * @return il valore di ritorno è sempre rigaDefinitiva, esso viene
     * aggiornato in base al ramo di if che si verifica
     */
    private RigaScontrino creaRiga(Scontrino s, Prodotto p) {
        //cerco su Db tutte le righe associate allo scontrino(param)
        RigaScontrino rigaDefinitiva = new RigaScontrino();
        System.out.println("siamo in creaRiga");
        Set<RigaScontrino> righeScontrino = s.getRigheScontrino();
        System.out.println("numero righeScontrino trovate associate a Scontrino : " + s.getId()
                + " = " + righeScontrino.size());

        if (!righeScontrino.isEmpty()) {
            System.out.println("siamo nel ramo if (righeScontrino.isEmpty()");
            List<RigaScontrino> lista = righeScontrino.stream()
                    .filter(r -> r.getProdotto().getId() == p.getId()).collect(Collectors.toList());
            System.out.println("Ho filtrato la lista che ora è di elementi: " + lista.size());
            if (lista.isEmpty()) {
                System.out.println("siamo nel ramo if (lista.isEmpty())");
                RigaScontrino riga1 = new RigaScontrino();
                riga1.setQuantita(1);
                System.out.println("creata nuova riga, quantità: " + riga1.getQuantita());
                associaRigaScoAProdotto(riga1, p);
                //le associo lo scontrino
                associaScontrinoARigaSco(s, riga1);
                rigaDefinitiva = riga1;
            } else if (lista.size() == 1) {
                System.out.println("siamo in else if (lista.size() == 1)");
                rigaDefinitiva = lista.get(0);
                int qta = rigaRepository.leggiQuantita(rigaDefinitiva.getId());
                rigaRepository.aggiornaQuantita(qta + 1);
                rigaDefinitiva = rigaRepository.findById(rigaDefinitiva.getId()).get();
            } else {
                throw new RuntimeException();
            }

        } //se non c'è la creo, le associo il prodotto, ne inizializzo la quantità,
        else if (righeScontrino.isEmpty()) {
            System.out.println("siamo nel ramo else if (righeScontrino.isEmpty())");
            RigaScontrino riga = new RigaScontrino();
            riga.setQuantita(1);
            System.out.println("creata nuova riga, quantità: " + riga.getQuantita());
            associaRigaScoAProdotto(riga, p);
            System.out.println("riga e prodotto associati con successo");
            //le associo lo scontrino
            associaScontrinoARigaSco(s, riga);
            System.out.println("riga e scontrino associati con successo");
            rigaDefinitiva = riga;
        }
        return rigaDefinitiva;
    }

    @Override
    public AnnullaScontrinoDto annullaScontrino(Scontrino scontrino, List<RigaScontrino> righeScontrino) {
        System.out.println("siamo in annullaScontrino");
        rigaRepository.deleteAll(righeScontrino);
        scontrinoRepository.delete(scontrino);

        return new AnnullaScontrinoDto();
    }

    @Override
    public StornaRitornoDto stornaUltimo(RigaScontrino rs, Scontrino s) {
        rigaRepository.delete(rs);
        Scontrino sco = scontrinoRepository.findById(s.getId()).get();
        Set<RigaScontrino> srs = sco.getRigheScontrino();
        return new StornaRitornoDto(srs);
    }

}
