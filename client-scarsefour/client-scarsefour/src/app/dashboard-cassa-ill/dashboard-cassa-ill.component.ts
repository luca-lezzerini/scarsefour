import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-ill/automa-ill';
import { AutomabileIll } from '../automa-gestione-cassa-ill/automabile-ill';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent, VediPrezzoEvent } from '../automa-gestione-cassa-ill/eventi-ill';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ReqEanDtoIll } from '../dto/req-ean-dto-ill';
import { Prodotto } from '../entità/prodotto';
import { Scontrino } from '../entità/scontrino';

@Component({
  selector: 'app-dashboard-cassa-ill',
  templateUrl: './dashboard-cassa-ill.component.html',
  styleUrls: ['./dashboard-cassa-ill.component.css', '../theme.css']
})
export class DashboardCassaIllComponent implements OnInit, AutomabileIll {

  automaIll: AutomaCassa;
  barcode = "";
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;

  ean: boolean;
  vediPrezzoV: boolean;
  table: boolean;
  storna: boolean;
  annullaScontrinoV: boolean;
  annullaScontrinoE: boolean;
  annullaV: boolean;
  annullaE: boolean;
  chiudi: boolean;
  chiudiE: boolean;
  prezzo: boolean;
  eanE: boolean;
  confermaV: boolean;
  confermaE: boolean;

  scontrino = new Scontrino();
  prodotti: Prodotto[] = [];


  ngOnInit(): void {
  }

  constructor(private http: HttpClient) {
    this.automaIll = new AutomaCassa(this);
  }


  vediPrezzo() {
    this.automaIll.next(new VediPrezzoEvent(), this.automaIll);
  }
  chiudiScontrino() {
    this.automaIll.next(new ChiudiEvent(), this.automaIll);
  }
  annullaScontrino() {
    this.automaIll.next(new AnnullaScontrinoEvent(), this.automaIll);
  }
  stornaUltimo() {
    this.automaIll.next(new StornaEvent(), this.automaIll);
  }

  conferma() {
    this.automaIll.next(new ConfermaEvent(), this.automaIll);

  }

  annulla() {
    this.automaIll.next(new AnnullaEvent(), this.automaIll);

  }

  generaEventoEan(barcode: string) {
    this.automaIll.next(new EanEvent(barcode), this.automaIll);

  }


  entraStatoScontrinoVuoto() {
    this.ean = true;
    this.eanE = false;
    this.vediPrezzoV = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoV = true;
    this.confermaV = true;
    this.annullaV = true;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoE = false;
    this.confermaE = false;
    this.annullaE = false;
    this.chiudiE = false;
  }
  entraStatoVediPrezzo() {
    this.ean = true;
    this.eanE = false;
    this.vediPrezzoV = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoV = false;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoE = false;
    this.confermaE = false;
    this.annullaE = false;
    this.chiudiE = false;
  }
  entraStatoScontrinoNonVuoto() {
    this.ean = true;
    this.eanE = false;
    this.vediPrezzoV = true;
    this.table = true;
    this.storna = true;
    this.annullaScontrinoV = true;
    this.confermaV = false;
    this.annullaV = false;
    this.chiudi = true;
    this.prezzo = true;
    this.annullaScontrinoE = false;
    this.confermaE = false;
    this.annullaE = false;
    this.chiudiE = false;

  }
  entraStatoAnnullamentoScontrino() {
    this.ean = false;
    this.eanE = false;
    this.vediPrezzoV = false;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoV = false;
    this.confermaV = true;
    this.annullaV = true;
    this.chiudi = false;
    this.prezzo = false;
    this.annullaScontrinoE = false;
    this.confermaE = false;
    this.annullaE = false;
    this.chiudiE = false;
  }

  trovaEan() {
    let dto = new ReqEanDtoIll();
    dto.codiceABarre = this.barcode;
    this.http.post<ProdottoDto>("http://localhost:8080/trova-ean", dto)
      .subscribe(ris => {
        let codiceEan = "";
        if (ris.prodotto) {
          this.prodotti.push(ris.prodotto);
          codiceEan = ris.prodotto.ean;
          this.prezzoTot = this.prezzoTot + ris.prodotto.prezzo;
          this.descrizioneE = ris.prodotto.descrizione;
          this.prezzoE = ris.prodotto.prezzo;
        }
        this.generaEventoEan(codiceEan);
      });
  }

}
