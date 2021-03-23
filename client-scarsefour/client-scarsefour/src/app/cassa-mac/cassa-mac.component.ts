import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-mac/automa';
import { EanEvent } from '../automa-gestione-cassa-mac/eventi';
import { AutomabileDashboardMac } from '../automa-gestione-cassa-mac/automabile-dashboard-mac';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { RicercaProdottoDto } from '../dto/ricerca-prodotto-dto';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';

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

  scontrino = new Scontrino();

  automaCassa: AutomaCassa;
  constructor(private http: HttpClient) {
    this.automaCassa = new AutomaCassa(this);
  }


  entraStatoVediPrezzo() {
    this.ean=true;
    this.vediPrezzoVis=false;
    this.chiudi=false;
    this.annullaScontrinoEnabled=false;
    this.annullaScontrinoVis=false;
    this.storna=false;
    this.confermaEnabled=false;
    this.annullaEnabled=false;
    this.table=false;
    this.prezzo=false;
    this.confermaVis=false;
    this.annullaVis=false;
    this.chiudiEnabled=false;

  }
  entraStatoScontrinoVuoto() {
    throw new Error('Method not implemented.');

  }
  entraStatoScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoAnnullamentoScontrino() {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
  }

  generaEanEvent(){
    this.automaCassa.next(new EanEvent(this.barcode), this.automaCassa);
  }


  ricercaEanEvent(){
    let dto = new RicercaProdottoDto();
    dto.ricercaPerCodice = this.barcode;
    if (this.barcode == null) {
    console.log("prodotto non trovato!");
     } else {
      this.http.post<ListaProdottiDto>("http://localhost:8080/ricerca-prodotto", dto)
        .subscribe(k => {
          this.prodotti = k.listaProdotti;
          this.barcode= "";
        });
    }
  }


  VediPrezzo() { }

  ChiudiScontrino() { }

  StornaUltimo() { }

  AnnullaScontrino() { }

  Annulla() { }

  Conferma() { }
}
