import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-mac/automa';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent, VediPrezzoEvent } from '../automa-gestione-cassa-mac/eventi';
import { AutomabileDashboardMac } from '../automa-gestione-cassa-mac/automabile-dashboard-mac';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { RicercaProdottoDto } from '../dto/ricerca-prodotto-dto';
import { Scontrino } from '../entità/scontrino';
import { Prodotto } from '../prodotto';
import { RigaScontrino } from '../entità/riga-scontrino';

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
  ricercaEan() {
    let dto = new RicercaProdottoDto();
    dto.ricercaPerCodice = this.barcode;
    if (this.barcode == null) {
      console.log("prodotto non trovato!");
    } else {
      this.http.post<ListaProdottiDto>("http://localhost:8080/ricerca-prodotto", dto)
        .subscribe(k => {
          this.prodotti = k.listaProdotti;
          this.barcode = "";
        });
    }
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
    this.chiudi = false;
    this.annullaScontrinoEnabled = false;
    this.annullaScontrinoVis = false;
    this.storna = false;
    this.confermaEnabled = false;
    this.annullaEnabled = false;
    this.table = false;
    this.prezzo = false;
    this.confermaVis = false;
    this.annullaVis = false;
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

  ngOnInit(): void {
  }

 

}
