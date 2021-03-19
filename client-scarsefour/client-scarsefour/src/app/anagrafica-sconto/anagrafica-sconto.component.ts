
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Aggiungi, Automa, Modifica, Rimuovi } from '../automa-crud/automa';
import { AddEvent, AnnullaEvent, ConfermaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaScontiDto } from '../dto/lista-sconti-dto';
import { RicercaScontiDto } from '../dto/ricerca-sconti-dto';
import { ScontiDto } from '../dto/sconti-dto';
import { Sconto } from '../entità/sconto';

@Component({
  selector: 'app-anagrafica-sconto',
  templateUrl: './anagrafica-sconto.component.html',
  styleUrls: ['./anagrafica-sconto.component.css']
})
export class AnagraficaScontoComponent implements OnInit {

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  automa: Automa;
  sconto = new Sconto();
  sconti: Sconto[] = [];

  criterioRicerca = "";


  nuova() { }

  modifica() { }

  conferma() {
    let dto = new ScontiDto();
    dto.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/aggiungi-prodotto-scontato", dto)
      .subscribe(r => {
        this.sconti = r.listaSconti;
        this.sconto = new Sconto();
      });
  }

  annulla() {
    this.sconto = new Sconto();
    this.automa.next(new AnnullaEvent, this.automa);
  }

  rimuovi() {
    let dtox = new ScontiDto();
    dtox.sconto = this.sconto;
    this.http.post<ListaScontiDto>("http://localhost:8080/rimuovi-prodotto-scontato", dtox)
      .subscribe(r => {
        this.sconti = r.listaSconti;
        this.sconto = new Sconto();
      });
  }

  cerca() { }
}