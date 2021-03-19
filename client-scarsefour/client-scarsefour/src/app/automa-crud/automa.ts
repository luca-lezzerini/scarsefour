import { of } from "rxjs";
import { Automabile } from "./automabile";
import { AddEvent, AnnullaEvent, ConfermaEvent, Event, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from "./eventi";
import { State } from "./stati";

export class Automa implements State {

    constructor(ui: Automabile) {
        this.ui = ui;
        this.stato = new Ricerca();
        console.log("Siamo nello stato: ", this.stato);
        ui.entraStatoRicerca();
    }

    stato: State;
    ui: Automabile;

    next(e: Event, a?: Automa) {
        console.log("Siamo nello stato: ", this.stato);
        console.log("Ricevuto evento: ", e);
        this.stato.next(e, a);
        console.log("Siamo arrivati nello stato: ", this.stato);
    }
}

export class Ricerca implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof AddEvent) {
            a.stato = new Aggiungi(a);
        }
        else if (e instanceof RicercaEvent) {
            a.ui.aggiornaRisultatiRicerca();
            console.log("UI Aggiornami la ricerca; a.ui.aggiornaRisultatiRicerca")
        }
        else if (e instanceof SelezionaEvent) {
            a.stato = new Visualizza();
            a.ui.entraStatoVisualizza();
        }
        else { console.log("Errore ricevuto evento ", e, "inatteso"); }
    }
}

export class Aggiungi implements State {

    constructor(a: Automa) {
        a.ui.entraStatoAggiungi();
    }

    next(e: Event, a?: Automa) {
        if (e instanceof ConfermaEvent) {
            a.ui.salvaDati();
            a.stato = new Visualizza();
            a.ui.entraStatoVisualizza();
        }
        else if (e instanceof AnnullaEvent) {
            a.stato = new Ricerca();
            a.ui.entraStatoRicerca();
        }
        else {
            console.log("Errore ricevuto evento ", e, "inatteso");
        }
    }
}

export class Visualizza implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof AddEvent) {
            a.stato = new Aggiungi(a);
            a.ui.entraStatoAggiungi();
        }
        else if (e instanceof SelezionaEvent) { }
        else if (e instanceof ModificaEvent) {
            a.stato = new Modifica();
            a.ui.entraStatoModifica();
        }
        else if (e instanceof RimuoviEvent) {
            a.stato = new Rimuovi();
            a.ui.entraStatoRimuovi();
        }
        else if (e instanceof RicercaEvent) {
            a.stato = new Ricerca();
            a.ui.entraStatoRicerca();
            a.ui.aggiornaRisultatiRicerca();
        }
        else {
            console.log("Errore ricevuto evento ", e, "inatteso");
        }
    }
}
export class Rimuovi implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof ConfermaEvent) {
            a.ui.eliminaDati();
            a.stato = new Ricerca();
            a.ui.entraStatoRicerca();
        } else if (e instanceof AnnullaEvent) {
            a.stato = new Visualizza();
            a.ui.entraStatoVisualizza();
        } else {
            console.log("Errore ricevuto evento ", e, "inatteso");
        }
    }

}

export class Modifica implements State {
    next(e: Event, a?: Automa) {
        if (e instanceof ConfermaEvent) {
            a.ui.modificaDati();
            a.stato = new Visualizza();
            a.ui.entraStatoVisualizza();
        } else if (e instanceof AnnullaEvent) {
            a.stato = new Visualizza();
            a.ui.entraStatoVisualizza();
        } else {
            console.log("Errore ricevuto evento ", e, "inatteso");
        }
    }

}