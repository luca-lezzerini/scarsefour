import { AutomabileGalli } from "./automabile-galli";
import { AnnullaEvent, AnnullaScontrinoEvent, ChiudiEvent, ConfermaEvent, EanEventGalli, StornaEvent, VediPrezzoEvent } from "./eventi-galli";
import { State } from "./state-galli";

export class Automa implements State {

    stato: State;
    ui: AutomabileGalli;

    constructor(ui: AutomabileGalli) {
        this.ui = ui;
        this.stato = new ScontrinoVuoto();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoScontrinoVuoto();
    }
    next(e: Event, a?: Automa) {
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
            } else if (e instanceof EanEventGalli) {
                a.ui.verificaEan();
                if (e.ean) {
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
        if (e instanceof EanEventGalli) {
            if (e.ean && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
            } else if (!e.ean && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
            } else if (!e.ean && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
            } else if (e.ean && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
            } else {
                console.log("errore inatteso");
            }
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class ScontrinoNonVuoto implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof ChiudiEvent) {
            a.stato = new ScontrinoVuoto();
        } else if (e instanceof StornaEvent) {
            if (e.numeroElementi == 1) {
                a.stato = new ScontrinoVuoto();
            } else if (e.numeroElementi > 1) {
                a.stato = new ScontrinoNonVuoto();
            }
        } else if (e instanceof EanEventGalli) {
            if (!e.ean) {
                a.stato = new ScontrinoNonVuoto();
            } else if (e.ean) {
                a.stato = new ScontrinoNonVuoto();
            }
        } else if (e instanceof AnnullaScontrinoEvent) {
            a.stato = new AnnullamentoScontrino();
        } else if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class AnnullamentoScontrino implements State {
    next(e: Event, a?: Automa) {

        if (e instanceof AnnullaEvent) {
            a.stato = new ScontrinoNonVuoto();
        } else if (e instanceof ConfermaEvent) {
            a.stato = new ScontrinoVuoto();
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}



