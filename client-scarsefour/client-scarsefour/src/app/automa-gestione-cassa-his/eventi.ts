import { Event } from "../automa-crud/eventi";

export class VediPrezzoEvent implements Event { }
export class ConfermaEvent implements Event { }
export class StornaEvent implements Event { }
export class ChiudiEvent implements Event { }
export class EanEvent implements Event {
    codiceEan:string;
}
export class AnnullaEvent implements Event { }
export class AnnullaScontrinoEvent implements Event { }

