
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Aggiungi, Automa, Modifica, Rimuovi } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaScontiDto } from '../dto/lista-sconti-dto';
import { RicercaScontiDto } from '../dto/ricerca-sconti-dto';
import { ScontiDto } from '../dto/sconti-dto';
import { Sconto } from '../entità/sconto';

@Component({
  selector: 'app-anagrafica-sconto',
  templateUrl: './anagrafica-sconto.component.html',
  styleUrls: ['./anagrafica-sconto.component.css', '../theme.css']
})
export class AnagraficaScontoComponent implements OnInit, Automabile {

  automa: Automa;
  sconto = new Sconto();
  sconti: Sconto[] = [];
  criterioRicerca = "";


  //Variabili di visualizzazione
  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean;
  annull: boolean;
  search: boolean;
  tabella: boolean;
  codiceInput: boolean;
  descrizione: boolean;


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
  }

  ngOnInit(): void {
  }


  nuova() {
    this.automa.next(new AddEvent(), this.automa);

  }
  rimuovi() {
    this.automa.next(new RimuoviEvent(), this.automa);
  }

  modifica() {
    this.automa.next(new ModificaEvent(), this.automa);
  }

  conferma() {
    this.automa.next(new ConfermaEvent(), this.automa)

  }

  annulla() {
    this.automa.next(new AnnullaEvent(), this.automa);
  }


  seleziona(s: Sconto) {
    this.sconto = s;
    this.automa.next(new SelezionaEvent(), this.automa);
  }
  cerca() {
    this.automa.next(new RicercaEvent(), this.automa);
  }

  aggiorna() {
    this.http.get<ListaScontiDto>("http://localhost:8080/aggiorna-prodotto-scontato")
      .subscribe(l => {
        this.sconti = l.listaSconti;
      });
  }

  ///////////////////////////////// METODI AUTOMABILE ////////////////////////////////////////////////////////////////

  entraStatoRicerca() {
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.codiceInput = false;
    this.descrizione = false;
    this.descrizione = false;
  }
  entraStatoAggiungi() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceInput = false;
    this.descrizione = false;
  }
  entraStatoVisualizza() {
    this.form = true;
    this.aggiungi = true;
    this.remove = true;
    this.edit = true;
    this.conf = false;
    this.annull = false;
    this.search = true;
    this.tabella = true;
    this.codiceInput = true;
    this.descrizione = true;
  }
  entraStatoModifica() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceInput = false;
    this.descrizione = false;
  }
  entraStatoRimuovi() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceInput = true;
    this.descrizione = true;
  }

  salvaDati() {
    let dto = new ScontiDto();
    dto.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/aggiungi-prodotto-scontato", dto)
      .subscribe(r => {
        this.sconti = r.listaSconti;
        this.sconto = new Sconto();
      });
  }
  modificaDati() {
    let dto1 = new ScontiDto();
    dto1.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/modifica-prodotto-scontato", dto1)
      .subscribe(a => {
        this.sconti = a.listaSconti;
        this.sconto = new Sconto();
        console.log("modificato sconto")
      });
  }
  eliminaDati() {
    let dto = new ScontiDto();
    dto.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/rimuovi-prodotto-scontato", dto)
      .subscribe(r => {
        this.sconti = r.listaSconti;
        this.sconto = new Sconto();
      });
  }
  aggiornaRisultatiRicerca() {
    let dto2 = new ScontiDto();
    dto2.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/ricerca-prodotto-scontato", dto2)
      .subscribe(r => this.sconti = r.listaSconti);
  }

}