import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaPosizioniDto } from '../dto/lista-posizioni-dto';
import { PosizioneDto } from '../dto/posizione-dto';
import { RicercaPreCriterioDto } from '../dto/ricerca-per-criterio-ricerca-dto';
import { Posizione } from '../entità/posizione';

@Component({
  selector: 'app-anagrafica-posizioni',
  templateUrl: './anagrafica-posizioni.component.html',
  styleUrls: ['./anagrafica-posizioni.component.css', '../theme.css']
})
export class AnagraficaPosizioniComponent implements OnInit {


  automa: Automa;

  posizione = new Posizione();
  posizioni: Posizione[] = [];

  inputRicerca = "";

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
    this.aggiornaRisultatiRicerca();
  }

  ngOnInit(): void {
  }


  /////////////////// Pulsanti dell'interfaccia utente ///////////////////
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


  seleziona(p: Posizione) {
    this.posizione = p;
    this.automa.next(new SelezionaEvent(), this.automa);
  }
  cerca() {
    this.automa.next(new RicercaEvent(), this.automa);
  }

  aggiorna() {
    this.http.get<ListaPosizioniDto>("http://localhost:8080/aggiorna-posizione")
      .subscribe(l => {
        this.posizioni = l.listaPosizioni;
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
    this.posizione = new Posizione();
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
    let dto = new PosizioneDto();
    dto.posizione = this.posizione;
    this.http.post<ListaPosizioniDto>("http://localhost:8080/aggiungi-posizione", dto)
      .subscribe(r => {
        this.posizioni = r.listaPosizioni;
        this.posizione = new Posizione();
      });
  }

  aggiornaRisultatiRicerca() {
    console.log("siamo in aggiornaRisultatiRicerca")
    let dto = new RicercaPreCriterioDto();
    dto.criterioRicerca = this.inputRicerca;
    console.log("criterio ricerca: ");
    console.log(this.inputRicerca);
    this.http.post<ListaPosizioniDto>("http://localhost:8080/ricerca-posizione", dto)
      .subscribe(l => {
        this.posizioni = l.listaPosizioni;
      });
  }

  modificaDati() {
    let dto = new PosizioneDto();
    dto.posizione = this.posizione;
    this.http.post<ListaPosizioniDto>("http://localhost:8080/modifica-posizione", dto)
      .subscribe(r => {
        this.posizioni = r.listaPosizioni;
        this.posizione = new Posizione();
      });
  }

  eliminaDati() {
    let dto = new PosizioneDto();
    dto.posizione = this.posizione;
    this.http.post<ListaPosizioniDto>("http://localhost:8080/rimuovi-posizione", dto)
      .subscribe(r => {
        this.posizioni = r.listaPosizioni;
        this.posizione = new Posizione();
      });
  }


}
