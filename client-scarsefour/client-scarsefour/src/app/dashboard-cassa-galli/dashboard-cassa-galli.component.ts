import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa, VediPrezzo } from '../automa-cassa-galli/automa';
import { AutomabileGalli } from '../automa-cassa-galli/automabile-galli';
import { VediPrezzoEvent } from '../automa-cassa-galli/eventi-galli';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ReqEanDtoGal } from '../dto/req-ean-dto-gal';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-dashboard-cassa-galli',
  templateUrl: './dashboard-cassa-galli.component.html',
  styleUrls: ['./dashboard-cassa-galli.component.css', '../theme.css']
})
export class DashboardCassaGalliComponent implements OnInit, AutomabileGalli {
  prodotto: Prodotto;
  barcode = "";
  prodotti: Prodotto[] = [];
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
  automa: Automa;
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
  scontrino = new Scontrino();

  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
  }

  ngOnInit(): void {
  }

  vediPrezzo() { }
  chiudiScontrino() { }
  stornaUltimo() { }
  annullaScontrino() { }
  annulla() { }
  conferma() { }

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
    let reqDtoEanGal = new ReqEanDtoGal();
    reqDtoEanGal.barcode = this.barcode;
    this.http.post<ProdottoDto>(this.url + "verifica-ean-gal", reqDtoEanGal)
      .subscribe(r => {
        this.prodotti.push(r.prodotto);
      });
  }
}
