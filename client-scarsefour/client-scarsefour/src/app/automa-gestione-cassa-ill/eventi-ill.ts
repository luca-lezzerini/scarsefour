import { Scontrino } from "../entità/scontrino";

export interface Event { }
export class EanEvent implements Event {
    constructor(codiceEan: string, scontrino?: Scontrino) {
        this.codiceEan = codiceEan;
        this.scontrino = scontrino;
    }
    codiceEan: string;
    scontrino = new Scontrino();
}
export class ConfermaEvent implements Event { }
export class StornaEvent implements Event {
    numeroElementi: number;
}
export class ChiudiEvent implements Event { }
export class VediPrezzoEvent implements Event { }
export class AnnullaEvent implements Event { }
export class AnnullaScontrinoEvent implements Event { }
