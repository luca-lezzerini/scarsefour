import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Aggiungi, Automa, Modifica, Rimuovi } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { CassaDto } from '../dto/cassa-dto';
import { ListaCasseDto } from '../dto/lista-casse-dto';
import { RicercaPreCriterioDto } from '../dto/ricerca-per-criterio-ricerca-dto';
import { Cassa } from '../entità/cassa';

@Component({
  selector: 'app-anagrafica-casse',
  templateUrl: './anagrafica-casse.component.html',
  styleUrls: ['./anagrafica-casse.component.css']
})
export class AnagraficaCasseComponent implements OnInit, Automabile {

  automa: Automa;

  cassa = new Cassa();
  casse: Cassa[] = [];

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
  codiceInput: boolean;
  descrizione: boolean;


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
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
    switch (true) {
      case this.automa.stato instanceof Aggiungi:
        let dto = new CassaDto();
        dto.cassa = this.cassa;
        this.http.post<ListaCasseDto>("http://localhost:8080/aggiungi-cassa", dto)
          .subscribe(r => {
            this.casse = r.listaCasse;
            this.cassa = new Cassa();
          });
        break;
      case this.automa.stato instanceof Rimuovi:
        let dto1 = new CassaDto();
        dto1.cassa = this.cassa;
        this.http.post<ListaCasseDto>("http://localhost:8080/rimuovi-cassa", dto1)
          .subscribe(r => {
            this.casse = r.listaCasse;
            this.cassa = new Cassa();
            console.log("Complimenti, hai eliminato una cassa di banane!")
          });
        break;
      case this.automa.stato instanceof Modifica:
        let dto2 = new CassaDto();
        dto2.cassa = this.cassa;
        this.http.post<ListaCasseDto>("http://localhost:8080/modifica-cassa", dto2)
          .subscribe(r => {
            this.casse = r.listaCasse;
            this.cassa = new Cassa();
            console.log("Complimenti, hai modificato una cassa di banane!")
          });
        break;
      default:
        console.log("errore critico")
        break;
    }
    this.automa.next(new ConfermaEvent, this.automa);
  }

  annulla() {
    this.automa.next(new AnnullaEvent, this.automa);

  }
  seleziona(c: Cassa) {
    this.cassa = c;
    this.automa.next(new SelezionaEvent, this.automa);
  }
  cerca() {
    let dto = new RicercaPreCriterioDto();
    dto.criterioRicerca = this.inputRicerca;
    this.http.post<ListaCasseDto>("http://localhost:8080/cerca-cassa-codice-like", dto)
    .subscribe(l => {
      this.casse = l.listaCasse;
    });
    this.automa.next(new RicercaEvent, this.automa);
  }

  aggiorna() {
    this.http.get<ListaCasseDto>("http://localhost:8080/aggiorna-cassa")
      .subscribe(l => {
        this.casse = l.listaCasse;
      });
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////

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

}


