import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { CassieraDto } from '../dto/cassiera-dto';
import { ListaCassiereDto } from '../dto/lista-cassieri-dto';
import { RicercaCassiereDto } from '../dto/ricerca-cassiere-dto';
import { Cassiera } from '../entità/cassiera';

@Component({
  selector: 'app-anagrafica-cassiere',
  templateUrl: './anagrafica-cassiere.component.html',
  styleUrls: ['./anagrafica-cassiere.component.css', '../theme.css']
})
export class AnagraficaCassiereComponent implements OnInit, Automabile {

  automa: Automa;

  cassiera = new Cassiera();
  cassiere: Cassiera[] = [];

  inputRicerca: string;

  //Variabili di visualizzazione
  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean = true;
  annull: boolean = true;
  search: boolean;
  tabella: boolean;
  nomeC: boolean;
  cognomeC: boolean;
  codiceC: boolean;

  errore = "";


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
    this.automa.next(new ConfermaEvent(), this.automa);
  }

  annulla() {
    this.automa.next(new AnnullaEvent(), this.automa);
  }

  seleziona(c: Cassiera) {
    this.confermaMod(c);
    this.automa.next(new SelezionaEvent(), this.automa);
  }

  cerca() {
    this.automa.next(new RicercaEvent(), this.automa);
  }

  aggiorna() {
    this.http.get<ListaCassiereDto>("http://localhost:8080/aggiorna-cassieri")
      .subscribe(r => this.cassiere = r.listaCassiere);
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
    this.cognomeC = false;

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

  salvaDati() {
    let dto = new CassieraDto();
    dto.cassiera = this.cassiera;
    this.http.post<ListaCassiereDto>("http://localhost:8080/add-cassiera", dto)
      .subscribe(r => {
        this.cassiere = r.listaCassiere;
        this.cassiera = new Cassiera();
      });
  }
  modificaDati() {
    let dtox2 = new CassieraDto();
    dtox2.cassiera = this.cassiera;
    this.http.post<ListaCassiereDto>("http://localhost:8080/conf-cassiera", dtox2)
      .subscribe(r => {
        this.cassiere = r.listaCassiere;
        this.cassiera = new Cassiera();
      });
  }
  eliminaDati() {
    let dtox = new CassieraDto();
    dtox.cassiera = this.cassiera;
    this.http.post<ListaCassiereDto>("http://localhost:8080/rim-cassiera", dtox)
      .subscribe(r => {
        this.cassiere = r.listaCassiere;
        this.cassiera = new Cassiera();
      });
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaCassiereDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaCassiereDto>("http://localhost:8080/ric-cassiera", dto)
        .subscribe(r => this.cassiere = r.listaCassiere);
    }
  }
  confermaMod(c: Cassiera) {
    let dto = new CassieraDto();
    dto.cassiera = c;
    this.http.post<CassieraDto>("http://localhost:8080/mod-cassiera", dto)
      .subscribe(r => {
        this.cassiera = r.cassiera;
      });
  }
}