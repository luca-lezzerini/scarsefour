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

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AnagraficaProdottiComponent,
    AnagraficaCasseComponent,
    AnagraficaCassiereComponent
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
