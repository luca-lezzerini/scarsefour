export interface AutomabileGalli {
    //Entriamo in Scontrino Vuoto
        // Da Initial
        entraStatoScontrinoVuotoEanDaInitial();
        //Da Scontrino Vuoto
        entraStatoScontrinoVuotoEanSconosciutoDaScontrinoVuoto();
        //Da Vedi Prezzo
        entraStatoScontrinoVuotoEanDaVediPrezzo();
        entraStatoScontrinoVuotoEanSconosciutoDaVediPrezzo();
        //Da Scontrino Non Vuoto
        entraStatoScontrinoVuotoStornaDaScontrinoNonVuoto();
        entraStatoScontrinoVuotoChiudiDaScontrinoNonVuoto();
        //Da Annulamento scontrino
        entraStatoScontrinoVuotoConfermaDaAnnulamentoScontrino();

    //Entriamo in Scontrino Non Vuoto
        //Da Scontrino Non vuoto
        entraStatoScontrinoNonVuotoStornaDaScontrinoNonVuoto();
        entraStatoScontrinoNonVuotoEanSconosciutoDaScontrinoNonVuoto();
        entraStatoScontrinoNonVuotoEanDaScontrinoNonVuoto();

        //Da Annulamento Scontrino
        entraStatoScontrinoNonVuotoAnnullaDaAnnulamentoScontrino();
        //Da Vedi Prezzo
        entraStatoScontrinoNonVuotoEanDaVediPrezzo();
        entraStatoScontrinoNonVuotoEanSconosciutoDaVediPrezzo();
        //Da Scontrino Vuoto
        entraStatoScontrinoNonVuotoEanDaScontrinoVuoto();

    //Entriamo in Annullamento Scontrino
        //Da Scontrino Non Vuoto
        entraStatoAnnulamentoScontrinoDaScontrinoNonVuoto();
    
    //Entriamo in Vedi Prezzo
        //Da Scontrino Non Vuoto
        entraStatoVediPrezzoVediPrezzoDaScontrinoNonVuoto();
        //Da Scontrino Vuoto
        entraStatoVediPrezzoVediPrezzoDaScontrinoVuoto();
}