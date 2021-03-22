import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-cassa-ill',
  templateUrl: './dashboard-cassa-ill.component.html',
  styleUrls: ['./dashboard-cassa-ill.component.css']
})
export class DashboardCassaIllComponent implements OnInit {
  barcode = "";
  descrizioneE = "";
  prezzoE = 0;
  prezzoTot = 0;
  constructor() { }

  ngOnInit(): void {
  }
  vediPrezzo() {

  }
  chiudiScontrino() {

  }
  annullaScontrino() {

  }
  stornaUltimo() {

  }
}
