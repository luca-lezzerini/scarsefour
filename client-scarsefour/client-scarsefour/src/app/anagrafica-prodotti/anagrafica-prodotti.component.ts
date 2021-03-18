import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-anagrafica-prodotti',
  templateUrl: './anagrafica-prodotti.component.html',
  styleUrls: ['./anagrafica-prodotti.component.css']
})
export class AnagraficaProdottiComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  prodotto = new Prodotto();
  prodotti: Prodotto[] = [];

  modifica() { }
  conferma() { }
  annulla() { }
  rimuovi() { }
  cerca() { }
  nuova() { }

}
