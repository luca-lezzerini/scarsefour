import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnagraficaCasseComponent } from './anagrafica-casse/anagrafica-casse.component';
import { AnagraficaProdottiComponent } from './anagrafica-prodotti/anagrafica-prodotti.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  {path: 'app-home-page', component: HomePageComponent},
  {path: 'app-anagrafica-prodotti', component: AnagraficaProdottiComponent},
  {path: 'app-anagrafica-casse', component: AnagraficaCasseComponent},
  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
