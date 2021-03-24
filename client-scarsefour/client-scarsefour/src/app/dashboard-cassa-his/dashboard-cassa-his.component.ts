import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { AutomaCassa, VediPrezzo } from '../automa-gestione-cassa-his/automa';
import { AutomabileDashboardHis } from '../automa-gestione-cassa-his/automabile-dashboard-his';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent, VediPrezzoEvent } from '../automa-gestione-cassa-his/eventi';
import { CreaRigaDto } from '../dto/crea-riga-dto';
import { CreaScontrinoDto } from '../dto/crea-scontrino-dto';
import { EanDtoHis } from '../dto/ean-dto-his';
import { LeggiEanRequestDto } from '../dto/leggi-ean-request-dto';
import { LeggiEanResponseDto } from '../dto/leggi-ean-response-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { RigaScontrino } from '../entità/riga-scontrino';
import { Scontrino } from '../entità/scontrino';

@Component({
  selector: 'app-dashboard-cassa-his',
  templateUrl: './dashboard-cassa-his.component.html',
  styleUrls: ['./dashboard-cassa-his.component.css', '../theme.css']
})
export class DashboardCassaHisComponent implements OnInit, AutomabileDashboardHis {


  barcode = "";
  ultimoProdotto = new Prodotto();
  prezzoTot = 0;
  prodotti: Prodotto[] = [];
  righeScontrino: RigaScontrino[] = [];
  rigaScontrino = new RigaScontrino();
  scontrino = new Scontrino();
  messaggioErrore = "";


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


  entraStatoScontrinoVuoto() {
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

  leggiEan() {
    let leggiEanRequestDto = new LeggiEanRequestDto();
    leggiEanRequestDto.eanProdotto = this.barcode;
    leggiEanRequestDto.scontrino = this.scontrino;
    this.http.post<LeggiEanResponseDto>("http://localhost:8080/verifica-ean", leggiEanRequestDto)
      .subscribe(r => {
        this.messaggioErrore = r.messaggio;
        this.scontrino = r.scontrino;
        this.righeScontrino.push(r.rigaScontrino);
        console.log(r);
      });
  }

  eliminaUltimoElemento() {

  }

  calcolaTotale(prezzo: number) {

  }

  definisciQuantita(riga: RigaScontrino) {

  }


}


