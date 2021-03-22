import { Event } from "../automa-crud/eventi";
import { Scontrino } from "../entità/scontrino";

export class VediPrezzoEvent implements Event { }
export class ConfermaEvent implements Event { }
export class StornaEvent implements Event {
    numeroElementi: number;
}
export class ChiudiEvent implements Event { }
export class EanEvent implements Event {
    constructor(codiceEan: string, scontrino?: Scontrino) {
        this.codiceEan = codiceEan;
        this.scontrino = scontrino;
    }
    codiceEan: string;
    scontrino = new Scontrino();
}
export class AnnullaEvent implements Event { }
export class AnnullaScontrinoEvent implements Event { }

