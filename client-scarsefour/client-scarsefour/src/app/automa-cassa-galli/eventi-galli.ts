import { Scontrino } from "../entità/scontrino";

export interface Event { }

export class VediPrezzoEvent implements Event { }
export class StornaEvent implements Event {
    numeroElementi: number;
 }
export class ChiudiEvent implements Event { }
export class ConfermaEvent implements Event { }
export class AnnullaEvent implements Event { }
export class AnnullaScontrinoEvent implements Event { }
export class EanEventGalli implements Event {
    constructor(ean: string, scontrino?: Scontrino) {
        this.ean = ean;
        this.scontrino = scontrino;
    }

    ean: string;
    scontrino = new Scontrino();
}
