import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cassa-mac',
  templateUrl: './cassa-mac.component.html',
  styleUrls: ['./cassa-mac.component.css']
})
export class CassaMacComponent implements OnInit {

  barcode = "";
  descrizioneP = "";
  prezzoP = 0;
  totale = 0;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  VediPrezzo() { }
  ChiudiScontrino() { }
  StornaUltimo() { }
  AnnullaScontrino() { }
  Annulla() { }
  Conferma() { }
}
