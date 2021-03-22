import { AutomabileIll } from "./automabile-ill";
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEvent, Event, StornaEvent, VediPrezzoEvent } from "./eventi-ill";
import { State } from "./stati-ill";

export class AutomaCassa implements State {

    constructor(ui: AutomabileIll) {
        this.ui = ui;
        this.stato = new ScontrinoVuoto();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoScontrinoVuoto();
    }

    stato: State;
    ui: AutomabileIll;

    next(e: Event, a?: AutomaCassa) {
        console.log("Sono nello stato ", this.stato);
        console.log("Ho ricevuto l'evento", e);
        this.stato.next(e, a);
        console.log("Siamo arrivati nello stato ", this.stato);
    }

}

export class ScontrinoVuoto implements State {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
            a.ui.entraStatoVediPrezzo();
        } else if (e instanceof EanEvent) {
            if (e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            } else {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuoto();
            }
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class ScontrinoNonVuoto implements State {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof ChiudiEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.entraStatoScontrinoVuoto();
        } else if (e instanceof StornaEvent) {
            if (e.numeroElementi == 1) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuoto();
            } else if (e.numeroElementi > 1) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            }
        } else if (e instanceof EanEvent) {
            if (!e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            } else if (e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            }
        } else if (e instanceof AnnullaScontrinoEvent) {
            a.stato = new AnnullamentoScontrino();
            a.ui.entraStatoAnnullamentoScontrino();
        } else if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
            a.ui.entraStatoVediPrezzo();
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class VediPrezzo implements State {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof EanEvent) {
            if (e.scontrino && e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            } else if (!e.codiceEan && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto();
            } else if (!e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuoto();
            } else if (e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuoto();
            }
        } else {
            console.log("Evento inaspettato");
        }
    }
}

export class AnnullamentoScontrino implements State {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof AnnullaEvent) {
            a.stato = new ScontrinoNonVuoto();
            a.ui.entraStatoScontrinoNonVuoto();
        } else if (e instanceof ConfermaEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.entraStatoScontrinoVuoto();
        } else {
            console.log("Evento inatteso");
        }
    }

}