import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa, VediPrezzo } from '../automa-cassa-galli/automa';
import { AutomabileGalli } from '../automa-cassa-galli/automabile-galli';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, StornaEvent, VediPrezzoEvent } from '../automa-cassa-galli/eventi-galli';
import { LeggiEanRequestDto } from '../dto/leggi-ean-request-dto';
import { LeggiEanResponseDto } from '../dto/leggi-ean-response-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ReqEanDtoGal } from '../dto/req-ean-dto-gal';
import { RigaScontrinoClientGalDto } from '../dto/riga-scontrino-client-gal-dto';
import { ScontrinoClientGalDto } from '../dto/scontrino-client-gal-dto';
import { RigaScontrino } from '../entità/riga-scontrino';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-dashboard-cassa-galli',
  templateUrl: './dashboard-cassa-galli.component.html',
  styleUrls: ['./dashboard-cassa-galli.component.css', '../theme.css']
})
export class DashboardCassaGalliComponent implements OnInit, AutomabileGalli {
  prodotto = new Prodotto();
  rigaScontrino = new RigaScontrino();
  barcode = "";
  prodotti: Prodotto[] = [];
  righescontrino: RigaScontrinoClientGalDto[] = [];
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
  automa: Automa;
  messaggioErrore = "";
  url = "http://localhost:8080/";

  ean: boolean;
  vediPrezzoVis: boolean;
  table: boolean;
  storna: boolean;
  annullaScontrinoVis: boolean;
  annullaScontrinoEnabled: boolean;
  confermaVis: boolean;
  confermaEnabled: boolean;
  annullaVis: boolean;
  annullaEnabled: boolean;
  chiudi: boolean;
  chiudiEnabled: boolean;
  prezzo: boolean;
  scontrino: Scontrino;

  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
  }
  entraStatoScontrinoVuotoEanDaInitial() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = true;
    this.confermaVis = true;
    this.annullaVis = true;
    this.chiudi = true;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoEanSconosciutoDaScontrinoVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoEanDaVediPrezzo() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoEanSconosciutoDaVediPrezzo() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoStornaDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoChiudiDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoVuotoConfermaDaAnnulamentoScontrino() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoStornaDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoEanSconosciutoDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoEanDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoAnnullaDaAnnulamentoScontrino() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoEanDaVediPrezzo() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoEanSconosciutoDaVediPrezzo() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoScontrinoNonVuotoEanDaScontrinoVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoAnnulamentoScontrinoDaScontrinoNonVuoto() {
    this.ean = false;
    this.vediPrezzoVis = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = true;
    this.annullaVis = true;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoVediPrezzoVediPrezzoDaScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }
  entraStatoVediPrezzoVediPrezzoDaScontrinoVuoto() {
    this.ean = true;
    this.vediPrezzoVis = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }

  ngOnInit(): void {
  }

  vediPrezzo() {
    this.automa.next(new VediPrezzoEvent, this.automa);
  }
  chiudiScontrino() {
    this.automa.next(new ChiudiEvent, this.automa);
  }
  stornaUltimo() {
    this.automa.next(new StornaEvent, this.automa);
  }
  annullaScontrino() {
    this.automa.next(new AnnullaScontrinoEvent, this.automa);
  }
  annulla() {
    this.automa.next(new AnnullaEvent, this.automa);
  }
  conferma() {
    this.automa.next(new ConfermaEvent, this.automa);
  }

  entraStatoScontrinoVuotoDaInitial() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = true;
    this.confermaVis = true;
    this.annullaVis = true;
    this.chiudi = true;
    this.prezzo = false;
    this.annullaScontrinoEnabled = true;
    this.confermaEnabled = true;
    this.annullaEnabled = true;
    this.chiudiEnabled = true;
  }


  entraStatoVediPrezzo() {
    this.ean = true;
    this.vediPrezzoVis = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
  }
  entraStatoScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoVis = true;
    this.confermaVis = false;
    this.annullaVis = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
  }
  entraStatoAnnullamentoScontrino() {
    this.ean = false;
    this.vediPrezzoVis = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoVis = false;
    this.confermaVis = true;
    this.annullaVis = true;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
  }

  verificaEan() {
    let reqDtoEanGal = new LeggiEanRequestDto();
    reqDtoEanGal.eanProdotto = this.barcode;
    reqDtoEanGal.scontrino = this.scontrino;
    this.http.post<LeggiEanResponseDto>(this.url + "verifica-ean-gal", reqDtoEanGal)
      .subscribe(r => {
        this.rigaScontrino = r.rigaScontrino;
        this.messaggioErrore = r.messaggio;
        this.scontrino = r.scontrino;
      });
    this.entraStatoScontrinoNonVuotoEanDaScontrinoVuoto();
  }

  barcodeHaPersoFocus(event) {
    console.log("Il codice a barre ha perso il focus");
  }

}
