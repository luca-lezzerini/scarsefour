import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { CassieraDto } from '../dto/cassiera-dto';
import { ListaCassiereDto } from '../dto/lista-cassieri-dto';
import { Cassiera } from '../entità/cassiera';

@Component({
  selector: 'app-anagrafica-cassiere',
  templateUrl: './anagrafica-cassiere.component.html',
  styleUrls: ['./anagrafica-cassiere.component.css']
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
  conf: boolean;
  annull: boolean;
  search: boolean;
  tabella: boolean;
  input: boolean;


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
  }
  ngOnInit(): void {
  }

  nuova() {
    this.automa.next(new AddEvent, this.automa);
  }
  rimuovi() {
    this.automa.next(new RimuoviEvent, this.automa);
  }
  modifica() {
    this.automa.next(new ModificaEvent, this.automa);
  }
  conferma() {
    //conferma da che stato???
    let dto = new CassieraDto();
    dto.cassiera = this.cassiera;
    this.http.post<ListaCassiereDto>("http://localhost:8080/add-cassiera", dto)
      .subscribe(r => {
        this.cassiere = r.listaCassiere;
        this.cassiera = new Cassiera();
      });
    this.automa.next(new ConfermaEvent, this.automa);
  }

  annulla() {
    this.automa.next(new AnnullaEvent, this.automa);

  }
  seleziona() {
    this.automa.next(new SelezionaEvent, this.automa);
  }
  cerca() {
    this.automa.next(new RicercaEvent, this.automa);
  }

  entraStatoRicerca() {
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.input = false;
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
    this.input = false;
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
    this.input = true;
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
    this.input = false;
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
    this.input = true;
  }
}