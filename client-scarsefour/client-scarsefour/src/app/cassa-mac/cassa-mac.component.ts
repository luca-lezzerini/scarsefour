import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-mac/automa';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent, VediPrezzoEvent } from '../automa-gestione-cassa-mac/eventi';
import { AutomabileDashboardMac } from '../automa-gestione-cassa-mac/automabile-dashboard-mac';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { RicercaProdottoDto } from '../dto/ricerca-prodotto-dto';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';
import { RigaScontrino } from '../entità/riga-scontrino';
import { ProdottoDto } from '../dto/prodotto-dto';
import { LeggiEanRequestDto } from '../dto/leggi-ean-request-dto';
import { LeggiEanResponseDto } from '../dto/leggi-ean-response-dto';

@Component({
  selector: 'app-cassa-mac',
  templateUrl: './cassa-mac.component.html',
  styleUrls: ['./cassa-mac.component.css', '../theme.css']
})
export class CassaMacComponent implements OnInit, AutomabileDashboardMac {

  barcode = "";
  descrizioneP = "";
  prezzoP = 0;
  totale = 0;
  prodotti: Prodotto[] = [];
  prodotto = new Prodotto();
  righeScontrino: RigaScontrino[] = [];
  rigaScontrino = new RigaScontrino();
  ultimoProdotto = new Prodotto();
  errore: boolean;



  ean: boolean;
  vediPrezzoV: boolean;
  listaScontrino: boolean; //tabella
  storna: boolean;
  annullaScontrinoV: boolean;
  annullaScontrinoEnabled: boolean; //si riferisce alla visibilita del bottone
  confermaV: boolean;
  confermaEnabled: boolean; //si riferisce alla visibilita del bottone
  annullaV: boolean;
  annullaEnabled: boolean; //si riferisce alla visibilita del bottone
  chiudi: boolean;
  chiudiEnabled: boolean; //si riferisce alla visibilita del bottone
  prezzo: boolean;

  scontrino = new Scontrino();

  automaCassa: AutomaCassa;
  constructor(private http: HttpClient) {
    this.automaCassa = new AutomaCassa(this);
  }

  ngOnInit(): void {
  }


  vediPrezzo() {
    this.automaCassa.next(new VediPrezzoEvent, this.automaCassa);
  }

  generaEanEvent(barcode: string) {
    this.automaCassa.next(new EanEvent(barcode), this.automaCassa);
  }

  chiudiScontrino() {
    this.automaCassa.next(new ChiudiEvent, this.automaCassa);
  }
  annullaScontrino() {
    this.automaCassa.next(new AnnullaScontrinoEvent, this.automaCassa);
  }
  stornaUltimo() {
    this.automaCassa.next(new StornaEvent(this.righeScontrino.length), this.automaCassa);
  }

  conferma() {
    this.automaCassa.next(new ConfermaEvent, this.automaCassa);
  }

  annulla() {
    this.automaCassa.next(new AnnullaEvent, this.automaCassa);
  }

  entraStatoScontrinoVuoto() {
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = false;
    this.storna = false;
    this.annullaScontrinoV = true;
    this.confermaV = true;
    this.annullaV = true;
    this.chiudi = true;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
    this.errore = false;

    //revisionato
  }
  entraStatoVediPrezzo() {
    this.ean = true;
    this.vediPrezzoV = false;
    this.chiudi = false;
    this.annullaScontrinoEnabled = false;
    this.annullaScontrinoV = false;
    this.storna = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.listaScontrino = false;
    this.prezzo = false;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudiEnabled = false;
    this.errore = false;

  }

  entraStatoScontrinoVuotoDaVediPrezzo() {
    //ean conosciuto
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
    this.errore = false;

    //revisionato
  }
  entraStatoScontrinoVuotoDaVediPrezzoErrore() {
    //ean sconosciuto
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
    this.errore = true;
    //revisionato

  }
  entraStatoScontrinoVuotoDaNonVuoto() {
    //da scontrino non vuoto a scontrino vuoto
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = true;
    this.errore = false;

    //revisionato (è uguale per storna un elemento)
  }

  entraStatoScontrinoVuotoDaAnnullaScontrino() {
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = false;
    this.storna = false;
    this.annullaScontrinoV = false;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = true;
    this.errore = false;
    //completato e revisionato
  }
  entraStatoScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
    this.errore = false;

    // completo (è uguale per tutte eccetto per errore)
  }
  entraStatoScontrinoNonVuotoErrore() {
    this.ean = true;
    this.vediPrezzoV = true;
    this.listaScontrino = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
    this.errore = true;
    //completo
  }
  entraStatoAnnullamentoScontrino() {
    this.ean = false;
    this.vediPrezzoV = false;
    this.listaScontrino = false;
    this.storna = false;
    this.annullaScontrinoV = false;
    this.confermaV = true;
    this.annullaV = true;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
    this.errore = false;
    //completo
  }


  ricercaEan() {
    let dto = new LeggiEanRequestDto();
    dto.eanProdotto = this.barcode;
    dto.scontrino = this.scontrino;
    /* if (this.barcode == null) {
       //console.log("prodotto non trovato!");
     } else {
       this.http.post<ListaProdottiDto>("http://localhost:8080/ricerca-prodotto-mac", dto)
         .subscribe(k => {
           this.prodotti = k.listaProdotti;
           this.barcode = "";
         });
     }*/

    this.http.post<LeggiEanResponseDto>("http://localhost:8080/ricerca-prodotto-mac", dto)
      .subscribe(a => {
        this.scontrino = a.scontrino;
        this.rigaScontrino = a.rigaScontrino;
        this.barcode = "";
      });

  }


}
