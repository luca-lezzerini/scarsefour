import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../prodotto';

@Component({
  selector: 'app-dashboard-cassa-galli',
  templateUrl: './dashboard-cassa-galli.component.html',
  styleUrls: ['./dashboard-cassa-galli.component.css']
})
export class DashboardCassaGalliComponent implements OnInit {

  constructor(private http: HttpClient) { }
  prodotto: Prodotto;

  ngOnInit(): void {
  }

  vediPrezzo() { }
  chiudiScontrino() { }
  stornaUltimo() { }
  annullaScontrino() { }
  annulla() { }
  conferma() { }
}
