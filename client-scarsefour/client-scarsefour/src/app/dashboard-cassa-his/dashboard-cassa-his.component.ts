import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { AutomaCassa } from '../automa-gestione-cassa-his/automa';
import { AutomabileDashboardHis } from '../automa-gestione-cassa-his/automabile-dashboard-his';
import { EanEvent } from '../automa-gestione-cassa-his/eventi';
import { EanDtoHis } from '../dto/ean-dto-his';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { Scontrino } from '../entità/scontrino';

@Component({
  selector: 'app-dashboard-cassa-his',
  templateUrl: './dashboard-cassa-his.component.html',
  styleUrls: ['./dashboard-cassa-his.component.css', '../theme.css']
})
export class DashboardCassaHisComponent implements OnInit, AutomabileDashboardHis {


  barcode = "";
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
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



  ngOnInit(): void {
  }
  vediPrezzo() { }

  generaEanEvent(barcode: string) {
    this.automaCassa.next(new EanEvent(barcode), this.automaCassa);
  }

  chiudiScontrino() {

  }
  annullaScontrino() {

  }
  stornaUltimo() {

  }

  conferma() {

  }

  annulla() {

  }

  entraStatoVediPrezzo() {
    throw new Error('Method not implemented.');
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
    this.prezzo = true;
    this.annullaScontrinoEnabled = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.chiudiEnabled = false;
  }
  entraStatoScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoAnnullamentoScontrino() {
    throw new Error('Method not implemented.');
  }

  leggiEan() {
    let eanDtoHis = new EanDtoHis();
    eanDtoHis.barcode = this.barcode;
    this.http.post<ProdottoDto>("http://localhost:8080/verifica-ean", eanDtoHis)
      .subscribe(r => {
        let codiceEan = "";
        if (r.prodotto) {
          this.prodotti.push(r.prodotto);
          codiceEan = r.prodotto.ean;
        }
        this.generaEanEvent(codiceEan);
      });
  }

}
