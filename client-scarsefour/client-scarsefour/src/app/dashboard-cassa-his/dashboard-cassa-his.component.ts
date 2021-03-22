import { Component, OnInit } from '@angular/core';
import { AutomabileDashboardHis } from '../automa-gestione-cassa-his/automabile-dashboard-his';

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

  ean:boolean;
  vediPrezzoVis:boolean;
  table:boolean;
  storna:boolean;
  annullaScontrinoVis:boolean;
  confermaVis:boolean;
  annullaVis:boolean;
  chiudi:boolean;
  prezzo:boolean;
  creaNuovoScontrino:boolean;

  constructor() { }



  ngOnInit(): void {
  }
  vediPrezzo() {

  }
  chiudiScontrino() {

  }
  annullaScontrino() {

  }
  tornaUltimo() {

  }

  conferma() {

  }

  annulla() {

  }

  entraStatoVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuoto() {

  }
  entraStatoScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoAnnullamentoScontrino() {
    throw new Error('Method not implemented.');
  }

}
