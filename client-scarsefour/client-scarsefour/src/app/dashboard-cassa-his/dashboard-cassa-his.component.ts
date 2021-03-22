import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-cassa-his',
  templateUrl: './dashboard-cassa-his.component.html',
  styleUrls: ['./dashboard-cassa-his.component.css','../theme.css']
})
export class DashboardCassaHisComponent implements OnInit {


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
  tornaUltimo() {

  }

}
