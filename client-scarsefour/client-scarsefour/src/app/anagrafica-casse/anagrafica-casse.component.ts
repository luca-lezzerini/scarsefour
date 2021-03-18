import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';

@Component({
  selector: 'app-anagrafica-casse',
  templateUrl: './anagrafica-casse.component.html',
  styleUrls: ['./anagrafica-casse.component.css']
})
export class AnagraficaCasseComponent implements OnInit,Automabile {

  automa: Automa;

  input1: string;
  input2: string;
  inputRicerca: string;

  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean;
  annull: boolean;
  search: boolean;
  tabella: boolean;
  codice: boolean;
  descrizione: boolean;


  constructor() { 
    this.automa = new Automa(this);
   }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
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

  /////////////////////////////////////////////////////////////////////////////////////////////////

  entraStatoRicerca() {
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.codice = false;
    this.descrizione = false;
    this.codice = false;
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
    this.codice = false;
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
    this.codice = true;
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
    this.codice = false;
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
    this.codice = true;
    this.descrizione = true;
  }

}


