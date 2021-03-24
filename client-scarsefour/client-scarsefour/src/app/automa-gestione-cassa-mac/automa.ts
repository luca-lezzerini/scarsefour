import { Automabile } from "../automa-crud/automabile";
import { AnnullaEvent, ConfermaEvent, Event } from "../automa-crud/eventi";
import { State } from "../automa-crud/stati";
import { Scontrino } from "../entità/scontrino";
import { AutomabileDashboardMac } from "./automabile-dashboard-mac";
import { AnnullaScontrinoEvent, ChiudiEvent, EanEvent, StornaEvent, VediPrezzoEvent } from "./eventi";
import { StateCassa } from "./stati";

export class AutomaCassa implements StateCassa {

    stato: StateCassa;
    ui: AutomabileDashboardMac;

    constructor(ui: AutomabileDashboardMac) {
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
} //completato

export class VediPrezzo implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof EanEvent) {
            if (e.codiceEan && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzo();
            } else if (!e.codiceEan && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();
            } else if (!e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();
            } else if (e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();

            } else {
                console.log("errore inatteso");
            }
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}
//completato

export class ScontrinoNonVuoto implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof ChiudiEvent) {
            a.stato = new ScontrinoVuoto();
        } else if (e instanceof StornaEvent) {
            if (e.numeroElementi == 1) {
                // a.ui.eliminaUltimoElemento();
                a.stato = new ScontrinoVuoto();
            } else if (e.numeroElementi > 1) {
                //a.ui.eliminaUltimoElemento();
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
            a.ui.entraStatoScontrinoVuotoDaAnnullaScontrino();
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}//completato

/*export class AvviaRicercaEan implements StateCassa {
    next(e: Event, a?: AutomaCassa) {
        if (e instanceof EanEvent) {
            if (e.codiceEan && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzo();
            } else if (!e.codiceEan && e.scontrino) {
                a.stato = new ScontrinoNonVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();
            } else if (!e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();
            } else if (e.codiceEan && !e.scontrino) {
                a.stato = new ScontrinoVuoto();
                a.ui.entraStatoScontrinoVuotoDaVediPrezzoErrore();

            } else {
                console.log("errore inatteso");
            }
        } else {
            console.log("ricevuto evento ", e, " inatteso");
        }
    }
}
*/
