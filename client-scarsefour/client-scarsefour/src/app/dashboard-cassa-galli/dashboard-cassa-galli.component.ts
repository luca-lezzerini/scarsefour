import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa, VediPrezzo } from '../automa-cassa-galli/automa';
import { AutomabileGalli } from '../automa-cassa-galli/automabile-galli';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, StornaEvent, VediPrezzoEvent } from '../automa-cassa-galli/eventi-galli';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ReqEanDtoGal } from '../dto/req-ean-dto-gal';
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
  righescontrino: RigaScontrino[] = [];
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
  entraStatoScontrinoVuotoEanDaInitial() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoEanSconosciutoDaScontrinoVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoEanDaVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoEanSconosciutoDaVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoStornaDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoChiudiDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoVuotoConfermaDaAnnulamentoScontrino() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoStornaDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoEanSconosciutoDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoEanDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoAnnullaDaAnnulamentoScontrino() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoEanDaVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoEanSconosciutoDaVediPrezzo() {
    throw new Error('Method not implemented.');
  }
  entraStatoScontrinoNonVuotoEanDaScontrinoVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoAnnulamentoScontrinoDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoVediPrezzoVediPrezzoDaScontrinoNonVuoto() {
    throw new Error('Method not implemented.');
  }
  entraStatoVediPrezzoVediPrezzoDaScontrinoVuoto() {
    throw new Error('Method not implemented.');
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
    let reqDtoEanGal = new ReqEanDtoGal();
    reqDtoEanGal.barcode = this.barcode;
    this.http.post<ProdottoDto>(this.url + "verifica-ean-gal", reqDtoEanGal)
      .subscribe(r => {
        if (r.prodotto) {
          this.rigaScontrino.prodotto = r.prodotto;
          this.barcode = r.prodotto.ean;
          for (let r of this.righescontrino) {
            if (this.rigaScontrino.prodotto.id == r.prodotto.id) {
              this.rigaScontrino.quantita++;
              break;
            }
          }
          this.descrizioneE = r.prodotto.descrizione;
          this.prezzoE = r.prodotto.prezzo;
          this.prezzoTot += r.prodotto.prezzo;
        }
      });
  }
}
