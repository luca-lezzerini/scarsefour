import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-his/automa';
import { AutomabileDashboardHis } from '../automa-gestione-cassa-his/automabile-dashboard-his';
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

  automa:AutomaCassa;
  constructor(private http: HttpClient) {
    this.automa = new AutomaCassa(this);
   }



  ngOnInit(): void {
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

  entraStatoVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuoto() {
    this.ean = true;
    this.vediPrezzoVis = true;
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
    throw new Error('Method not implemented.');
  }
  entraStatoAnnullamentoScontrino() {
    throw new Error('Method not implemented.');
  }

}
