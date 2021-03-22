import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomabileDashboardMac } from '../automa-gestione-cassa-mac/automabile-dashboard-mac';

@Component({
  selector: 'app-cassa-mac',
  templateUrl: './cassa-mac.component.html',
  styleUrls: ['./cassa-mac.component.css']
})
export class CassaMacComponent implements OnInit, AutomabileDashboardMac {

  barcode = "";
  descrizioneP = "";
  prezzoP = 0;
  totale = 0;

  constructor(private http: HttpClient) { }
  entraStatoVediPrezzo() {
    throw new Error('Method not implemented.');
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
  VediPrezzo() { }
  ChiudiScontrino() { }
  StornaUltimo() { }
  AnnullaScontrino() { }
  Annulla() { }
  Conferma() { }
}
