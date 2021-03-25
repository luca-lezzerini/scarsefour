import { Event } from "../automa-crud/eventi";
import { StateCassa } from "../automa-gestione-cassa-his/stati";
import { AutomabileDashboardHis } from "./automabile-dashboard-his";
import { AnnullaScontrinoEvent, ChiudiEvent, EanEvent, StornaEvent, VediPrezzoEvent, AnnullaEvent, ConfermaEvent, } from "./eventi";

export class AutomaCassa implements StateCassa {

    stato: StateCassa;
    ui: AutomabileDashboardHis;

    constructor(ui: AutomabileDashboardHis) {
        this.ui = ui;
        this.stato = new ScontrinoVuoto();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoScontrinoVuoto();
    }

    next(e: Event, a?: AutomaCassa) {
        console.log("Siamo nello stato: ", this.stato);
        console.log("Ricevuto evento: ", e);
        this.stato.next(e, a);
        console.log("Siamo arrivati nello stato: ", this.stato);
    }
}

export class ScontrinoVuoto implements StateCassa {
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
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class VediPrezzo implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof EanEvent) {
            if (e.codiceEan && e.scontrino) {
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

            } else {
                console.log("errore inatteso");
            }
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class ScontrinoNonVuoto implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof ChiudiEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.entraStatoScontrinoVuotoEvChiudi();
            a.ui.stampaScontrino();
        } else if (e instanceof StornaEvent) {
            if (e.numeroElementi == 1) {
                a.ui.eliminaUltimoElemento();
                a.stato = new ScontrinoVuoto();
            } else if (e.numeroElementi > 1) {
                a.ui.eliminaUltimoElemento();
                a.stato = new ScontrinoNonVuoto();
            }
        } else if (e instanceof EanEvent) {
            if (!e.codiceEan) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoNonVuoto
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
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

export class AnnullamentoScontrino implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof AnnullaEvent) {
            a.stato = new ScontrinoNonVuoto();
            a.ui.entraStatoScontrinoNonVuoto();
        } else if (e instanceof ConfermaEvent) {
            a.stato = new ScontrinoVuoto();
            a.ui.confermaAnnullaScontrino();
            a.ui.entraStatoScontrinoVuoto();
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}

