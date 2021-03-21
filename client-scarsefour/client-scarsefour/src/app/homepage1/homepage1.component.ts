import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage1',
  templateUrl: './homepage1.component.html',
  styleUrls: ['./homepage1.component.css', '../theme.css']
})
export class Homepage1Component implements OnInit {

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  immagine1:string = "assets/immagini/1.jpg";

  anagraficaProdotti() {
    this.router.navigateByUrl('/app-anagrafica-prodotti');
  }  

  anagraficaCassiere() {
    this.router.navigateByUrl('/app-anagrafica-cassiere');
  }
  anagraficaCassa(){
    this.router.navigateByUrl('/app-anagrafica-casse');
  }
  anagraficaSconto(){
    this.router.navigateByUrl('/app-anagrafica-sconto');
  }

  anagraficaPosizione(){
    this.router.navigateByUrl('/app-anagrafica-posizione');
  }
}
