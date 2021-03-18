import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Aggiungi, Automa, Rimuovi } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { CassieraDto } from '../dto/cassiera-dto';
import { ListaCassiereDto } from '../dto/lista-cassieri-dto';
import { RicercaCassiereDto } from '../dto/ricerca-cassiere-dto';
import { Cassiera } from '../entità/cassiera';

@Component({
  selector: 'app-anagrafica-cassiere',
  templateUrl: './anagrafica-cassiere.component.html',
  styleUrls: ['./anagrafica-cassiere.component.css']
})
export class AnagraficaCassiereComponent implements OnInit, Automabile {

  automa: Automa;

  cassiera = new Cassiera();
  listaCassiere: Cassiera[] = [];

  inputRicerca: string;

  //Variabili di visualizzazione
  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean;
  annull: boolean;
  search: boolean;
  tabella: boolean;
  nomeC: boolean;
  cognomeC: boolean;
  codiceC: boolean;


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
  }
  ngOnInit(): void {
  }

  nuova() {
    this.automa.next(new AddEvent, this.automa);
  }
  rimuovi(c: Cassiera) {
    this.cassiera = c;
    this.automa.next(new RimuoviEvent, this.automa);
  }
  modifica() {
    let dto = new CassieraDto();
    dto.cassiera = this.cassiera;
    this.http.post<CassieraDto>("http://localhost:8080/mod-cassiera", dto)
      .subscribe(r => this.cassiera = r.cassiera)
    this.automa.next(new ModificaEvent, this.automa);
  }

  conferma() {
    switch (true) {
      case this.automa.stato instanceof Aggiungi:
        let dto = new CassieraDto();
        dto.cassiera = this.cassiera;
        this.http.post<ListaCassiereDto>("http://localhost:8080/add-cassiera", dto)
          .subscribe(r => {
            this.listaCassiere = r.listaCassiere;
            this.cassiera = new Cassiera();
          });
        break;
      case this.automa.stato instanceof Rimuovi:
        let dtox = new CassieraDto();
        dtox.cassiera = this.cassiera;
        this.http.post<ListaCassiereDto>("http://localhost:8080/rim-cassiera", dtox)
          .subscribe(r => {
            this.listaCassiere = r.listaCassiere;
            this.cassiera = new Cassiera();
          });
        break;
      default:
        console.log("errore")
        break;
    }
    this.automa.next(new ConfermaEvent, this.automa);
  }

  annulla() {
    this.cassiera = new Cassiera();
    this.automa.next(new AnnullaEvent, this.automa);

  }

  seleziona(c: Cassiera) {
    this.cassiera = c;
    this.automa.next(new SelezionaEvent, this.automa);
  }

  cerca() {
    let dto = new RicercaCassiereDto();
    dto.criterioRicerca = this.inputRicerca;
    this.http.post<ListaCassiereDto>("http://localhost:8080/ric-cassiera", dto)
      .subscribe(r => this.listaCassiere = r.listaCassiere)
    this.automa.next(new RicercaEvent, this.automa);
  }

  aggiorna() {
    this.http.get<ListaCassiereDto>("http://localhost:8080/aggiorna-cassieri")
      .subscribe(r => this.listaCassiere = r.listaCassiere);
  }

  entraStatoRicerca() {
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.nomeC = false;
    this.cognomeC = false;
    this.codiceC = false;
    this.remove = false;
    this.edit = false;
    this.conf = false;
    this.annull = false;

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
    this.nomeC = false;
    this.codiceC = false;
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
    this.nomeC = true;
    this.cognomeC = true;
    this.codiceC = true;
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
    this.nomeC = false;
    this.cognomeC = false;
    this.codiceC = false;
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
    this.nomeC = true;
    this.cognomeC = true;
    this.codiceC = true;
  }
}