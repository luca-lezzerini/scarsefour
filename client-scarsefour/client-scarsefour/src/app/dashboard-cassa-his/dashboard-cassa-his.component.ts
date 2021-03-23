import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { AutomaCassa, VediPrezzo } from '../automa-gestione-cassa-his/automa';
import { AutomabileDashboardHis } from '../automa-gestione-cassa-his/automabile-dashboard-his';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent } from '../automa-gestione-cassa-his/eventi';
import { EanDtoHis } from '../dto/ean-dto-his';
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
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
  prodotti: Prodotto[] = [];
  righeScontrino: RigaScontrino[] = [];
  rigaScontrino = new RigaScontrino();

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
  vediPrezzo() {
    this.automaCassa.next(new VediPrezzo, this.automaCassa);
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
  entraStatoScontrinoNonVuoto() {
    this.ean = true;
    this.vediPrezzoVis = false;
    this.table = true;
    this.storna = false;
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
    let eanDtoHis = new EanDtoHis();
    eanDtoHis.barcode = this.barcode;
    this.http.post<ProdottoDto>("http://localhost:8080/verifica-ean", eanDtoHis)
      .subscribe(r => {
        let codiceEan = "";
        if (r.prodotto) {
          let rigaScontrino = new RigaScontrino();
          rigaScontrino.prodotto = r.prodotto;
          // this.rigaScontrino.prodotto = r.prodotto;
          codiceEan = r.prodotto.ean;
          this.definisciQuantita(rigaScontrino);
          console.log(this.righeScontrino);
        }
        this.generaEanEvent(codiceEan);

      });
  }

  eliminaUltimoElemento() {
    this.righeScontrino.pop();
    console.log(this.righeScontrino);
  }

  definisciQuantita(riga: RigaScontrino) {
    let trovato: boolean;
    for (let r of this.righeScontrino) {
      if (r.prodotto.id == riga.prodotto.id) {
        r.quantita++;
        console.log("trovato prodotto uguale");
        trovato = true;
        break;
      }
    }
    if (!trovato) {
      console.log("prodotto uguale non trovato")
      riga.quantita = 1;
      this.righeScontrino.push(riga);
    }

    // if (this.righeScontrino.includes(riga)) {
    //   riga.quantita++;
    // } else {
    //   riga.quantita = 1;
    //   this.righeScontrino.push(riga);
    // }
  }
}
