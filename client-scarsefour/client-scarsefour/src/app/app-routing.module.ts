import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnagraficaCasseComponent } from './anagrafica-casse/anagrafica-casse.component';
import { AnagraficaCassiereComponent } from './anagrafica-cassiere/anagrafica-cassiere.component';
import { AnagraficaPosizioniComponent } from './anagrafica-posizioni/anagrafica-posizioni.component';
import { AnagraficaProdottiComponent } from './anagrafica-prodotti/anagrafica-prodotti.component';
import { AnagraficaScontoComponent } from './anagrafica-sconto/anagrafica-sconto.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [

  { path: 'app-home-page', component: HomePageComponent },
  { path: 'app-anagrafica-prodotti', component: AnagraficaProdottiComponent },
  { path: 'app-anagrafica-cassiere', component: AnagraficaCassiereComponent },
  { path: 'app-anagrafica-casse', component: AnagraficaCasseComponent },
  { path: 'app-anagrafica-sconto', component: AnagraficaScontoComponent },
  { path: 'app-anagrafica-posizione', component:AnagraficaPosizioniComponent },
  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
