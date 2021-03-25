import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AutomaCassa } from '../automa-gestione-cassa-ill/automa-ill';
import { AutomabileIll } from '../automa-gestione-cassa-ill/automabile-ill';
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, StornaEvent, VediPrezzoEvent } from '../automa-gestione-cassa-ill/eventi-ill';
import { CreaRigaDto } from '../dto/crea-riga-dto';
import { CreaScontrinoDto } from '../dto/crea-scontrino-dto';
import { LeggiEanRequestDto } from '../dto/leggi-ean-request-dto';
import { LeggiEanResponseDto } from '../dto/leggi-ean-response-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ReqEanDtoIll } from '../dto/req-ean-dto-ill';
import { RigaScontrinoDtoIll } from '../dto/riga-scontrino-ill--dto';
import { ScontrinoIllDto } from '../dto/scontrino-ill-dto';
import { Prodotto } from '../entità/prodotto';
import { RigaScontrino } from '../entità/riga-scontrino';
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
  mostraPrezzo = 0;
  ultimoElemento = new Prodotto();
  messaggioErrore = "";

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
  prodotto = new Prodotto();
  rigaScontrino = new RigaScontrino();
  righeScontrino: RigaScontrinoDtoIll[] = [];


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
    this.automaIll.next(new StornaEvent(this.righeScontrino.length), this.automaIll);
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

  entraStatoScontrinoVuotoIniziale() {
    this.ean = true;
    this.eanE = false;
    this.vediPrezzoV = true;
    this.table = false;
    this.storna = false;
    this.annullaScontrinoV = true;
    this.confermaV = true;
    this.annullaV = true;
    this.chiudi = true;
    this.prezzo = false;
    this.annullaScontrinoE = true;
    this.confermaE = true;
    this.annullaE = true;
    this.chiudiE = true;
  }
  entraStatoScontrinoVuoto() {
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
  entraStatoScontrinoVuotoQuandoVuoto() {
    this.ean = true;
    this.eanE = false;
    this.vediPrezzoV = true;
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
    let dto = new LeggiEanRequestDto();
    dto.eanProdotto = this.barcode;
    dto.scontrino = this.scontrino;
    this.http.post<LeggiEanResponseDto>("http://localhost:8080/trova-ean-ill", dto)
      .subscribe(ris => {
        this.scontrino = ris.scontrino;
        this.rigaScontrino = ris.rigaScontrino;
        this.messaggioErrore = ris.messaggio;
        this.generaEventoEan(ris.rigaScontrino.prodotto.ean);
      });
  }

  cancellaUltimo() {
    this.righeScontrino.pop();
    if (this.righeScontrino.length == 0) {
      this.prezzoTot = 0;
    }
  }

  creaScontrino() {
    let dto = new CreaScontrinoDto();
    dto.scontrino = this.scontrino;
    this.http.post<CreaScontrinoDto>("http://localhost:8080/crea-scontrino", dto)
      .subscribe(r => {
        this.scontrino = r.scontrino;
      })
  }

  creaRigaScontrino(rigaScontrino: RigaScontrino) {
    let dto = new CreaRigaDto();
    dto.riga = rigaScontrino;
    this.http.post<CreaRigaDto>("http://localhost:8080/crea-riga-scontrino", dto)
      .subscribe(r => {
        this.rigaScontrino = r.riga;
      })
  }

}
