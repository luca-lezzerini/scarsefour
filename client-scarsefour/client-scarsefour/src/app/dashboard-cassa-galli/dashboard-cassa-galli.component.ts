import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-cassa-galli/automa';
import { AutomabileGalli } from '../automa-cassa-galli/automabile-galli';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-dashboard-cassa-galli',
  templateUrl: './dashboard-cassa-galli.component.html',
  styleUrls: ['./dashboard-cassa-galli.component.css']
})
export class DashboardCassaGalliComponent implements OnInit, AutomabileGalli {
  prodotto: Prodotto;
  prodotti: Prodotto[] = [];
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
  automa: Automa;

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

  ngOnInit(): void {
  }
  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
  }
  entraStatoScontrinoVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoAnnullamentoScontrino() {
    throw new Error('Method not implemented.');
  }
  verificaEan() {
    throw new Error('Method not implemented.');
  }

  vediPrezzo() {
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

}