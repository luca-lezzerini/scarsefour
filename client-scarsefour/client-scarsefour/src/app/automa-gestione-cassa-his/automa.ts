import { Automa } from "../automa-crud/automa";
import { Automabile } from "../automa-crud/automabile";
import { Event } from "../automa-crud/eventi";
import { State } from "../automa-crud/stati";
import { EanEvent, VediPrezzoEvent } from "./eventi";

export class AutomaCassa {
    constructor(ui: Automabile) {
        this.ui = ui;
        this.stato = new ScontrinoVuoto();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoRicerca();
    }

    stato: State;
    ui: Automabile;

    next(e: Event, a?: AutomaCassa) {
        console.log("Siamo nello stato: ", this.stato);
        console.log("Ricevuto evento: ", e);
        this.stato.next(e, a);
        console.log("Siamo arrivati nello stato: ", this.stato);
    }


}

export class ScontrinoVuoto implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
        } else if (e instanceof EanEvent) {
            if (e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
            } else {
                a.stato = new ScontrinoVuoto();
            }
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class VediPrezzo implements State {
    next(e: Event, a?: Automa) {
        throw new Error("Method not implemented.");
    }
}

export class ScontrinoNonVuoto implements State {
    next(e: Event, a?: Automa) {
        throw new Error("Method not implemented.");
    }
}

export class AnnullamentoScontrino implements State {
    next(e: Event, a?: Automa) {
        throw new Error("Method not implemented.");
    }
}

