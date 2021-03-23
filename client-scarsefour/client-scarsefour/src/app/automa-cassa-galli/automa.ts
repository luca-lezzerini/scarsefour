import { AutomabileGalli } from "./automabile-galli";
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEventGalli, StornaEvent, VediPrezzoEvent } from "./eventi-galli";
import { State } from "./state-galli";
import {Event } from "./eventi-galli";

export class Automa implements State {

    stato: State;
    ui: AutomabileGalli;

    constructor(ui: AutomabileGalli) {
        this.ui = ui;
        this.stato = new ScontrinoVuoto();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoScontrinoVuotoEanDaInitial();
    }

    next(e: Event, a?: Automa) {
        console.log("Sono nello stato ", this.stato);
        console.log("Ho ricevuto l'evento", e);
        this.stato.next(e, a);
        console.log("Siamo arrivati nello stato ", this.stato);
    }
}

export class ScontrinoVuoto implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
            a.ui.entraStatoVediPrezzoVediPrezzoDaScontrinoVuoto();
        } else if (e instanceof EanEventGalli) {
            a.ui.entraStatoScontrinoVuotoEanSconosciutoDaScontrinoVuoto();
            if (e.ean) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoEanDaScontrinoVuoto();
            }
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class ScontrinoNonVuoto implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof ChiudiEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.entraStatoScontrinoVuotoChiudiDaScontrinoNonVuoto();
        } else if (e instanceof StornaEvent) {
            if (e.numeroElementi == 1) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoStornaDaScontrinoNonVuoto();
            } else if (e.numeroElementi > 1) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoStornaDaScontrinoNonVuoto();
            }
        } else if (e instanceof EanEventGalli) {
            if (!e.ean) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoEanDaScontrinoNonVuoto();
            } else if (e.ean) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoEanDaScontrinoNonVuoto();
            }
        } else if (e instanceof AnnullaScontrinoEvent) {
            a.stato = new AnnullamentoScontrino();
            a.ui.entraStatoScontrinoNonVuotoAnnullaDaAnnulamentoScontrino();
        } else if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
            a.ui.entraStatoVediPrezzoVediPrezzoDaScontrinoNonVuoto();
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class VediPrezzo implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof EanEventGalli) {
            if (e.scontrino && e.ean) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoEanDaVediPrezzo();
            } else if (!e.ean && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuotoEanSconosciutoDaVediPrezzo();
            } else if (!e.ean && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoEanSconosciutoDaVediPrezzo();
            } else if (e.ean && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoEanDaVediPrezzo();
            }
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class AnnullamentoScontrino implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof AnnullaEvent) {
            a.stato = new ScontrinoNonVuoto();
            a.ui.entraStatoScontrinoNonVuotoAnnullaDaAnnulamentoScontrino();
        } else if (e instanceof ConfermaEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.entraStatoScontrinoVuotoConfermaDaAnnulamentoScontrino();
        } else {
            console.log("Evento inatteso");
        }
    }
}



