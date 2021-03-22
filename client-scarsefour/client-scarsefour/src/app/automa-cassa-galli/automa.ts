import { AutomabileGalli } from "./automabile-galli";
import { EanEventGalli, VediPrezzoEvent } from "./eventi-galli";
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
        if (e instanceof EanEventGalli) {
            //Verificare che l'ean esiste nel db
            if (e.ean == null || e.ean == "")
                //Dopo di che se non esiste lo stato rimane ScontrinoVuoto    
                a.stato = new ScontrinoVuoto();
            else
                a.stato = new ScontrinoNonVuoto();
        }

        if (e instanceof VediPrezzoEvent) {
            a.stato = new VediPrezzo();
        }
        throw new Error("Method not implemented.");
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