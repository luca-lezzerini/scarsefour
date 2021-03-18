
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-anagrafica-sconto',
  templateUrl: './anagrafica-sconto.component.html',
  styleUrls: ['./anagrafica-sconto.component.css']
})
export class AnagraficaScontoComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  prodotto = new Prodotto();
  prodotti: Prodotto[] = [];
  

  nuova() { }

  modifica() { }

  conferma() { }

  annulla() { }

  rimuovi() { }

  cerca() { }
}