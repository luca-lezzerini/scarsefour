import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AnagraficaProdottiComponent } from './anagrafica-prodotti/anagrafica-prodotti.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AnagraficaCasseComponent } from './anagrafica-casse/anagrafica-casse.component';
import { AnagraficaCassiereComponent } from './anagrafica-cassiere/anagrafica-cassiere.component';
import { AnagraficaScontoComponent } from './anagrafica-sconto/anagrafica-sconto.component';
import { AnagraficaPosizioniComponent } from './anagrafica-posizioni/anagrafica-posizioni.component';
import { Homepage1Component } from './homepage1/homepage1.component';
import { CassaMacComponent } from './cassa-mac/cassa-mac.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AnagraficaProdottiComponent,
    AnagraficaCasseComponent,
    AnagraficaCassiereComponent,
    AnagraficaScontoComponent,
    AnagraficaPosizioniComponent,
    Homepage1Component,
    CassaMacComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
