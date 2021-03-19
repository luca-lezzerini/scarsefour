import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automabile } from '../automa-crud/automabile';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Aggiungi, Automa, Modifica, Rimuovi } from '../automa-crud/automa';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { Prodotto } from '../prodotto';
import { RicercaPreCriterioDto } from '../dto/ricerca-per-criterio-ricerca-dto';

@Component({
  selector: 'app-anagrafica-prodotti',
  templateUrl: './anagrafica-prodotti.component.html',
  styleUrls: ['./anagrafica-prodotti.component.css']
})
export class AnagraficaProdottiComponent implements OnInit, Automabile {
  automa: Automa;

  prodotto = new Prodotto();
  prodotti: Prodotto[] = [];

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
         let dto = new ProdottoDto();
         dto.prodotto = this.prodotto;
         this.http.post<ListaProdottiDto>("http://localhost:8080/aggiungi-prodotto", dto)
          .subscribe(r => {
             this.prodotti = r.listaProdotti;
             this.prodotto = new Prodotto();
             console.log("Aggiunto prodotto!")
           });
         break;
       case this.automa.stato instanceof Rimuovi:
         let dto1 = new ProdottoDto();
         dto1.prodotto = this.prodotto;
         this.http.post<ListaProdottiDto>("http://localhost:8080/rimuovi-prodotto", dto1)
           .subscribe(r => {
             this.prodotti = r.listaProdotti;
             this.prodotto = new Prodotto();
             console.log("Rimosso prodotto!")
           });
         break;
       case this.automa.stato instanceof Modifica:
         let dto2 = new ProdottoDto();
         dto2.prodotto = this.prodotto;
         this.http.post<ListaProdottiDto>("http://localhost:8080/modifica-prodotto", dto2)
           .subscribe(r => {
             this.prodotti = r.listaProdotti;
             this.prodotto = new Prodotto();
             console.log("modificato prodotto")
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
  seleziona(p:Prodotto) {
    this.prodotto = new Prodotto();
    this.automa.next(new SelezionaEvent, this.automa);
  }
  cerca() {
     let dto = new RicercaPreCriterioDto();
     dto.criterioRicerca = this.inputRicerca;
     this.http.post<ListaProdottiDto>("http://localhost:8080/ricerca-prodotto", dto)
     .subscribe(k => {
       this.prodotti = k.listaProdotti;
     });
   this.automa.next(new RicercaEvent, this.automa);
  }

  aggiorna() {
     this.http.get<ListaProdottiDto>("http://localhost:8080/aggiorna-prodotto")
       .subscribe(p => {
         this.prodotti = p.listaProdotti;
       });
  }

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

  salvaDati(){
    
  }

}




