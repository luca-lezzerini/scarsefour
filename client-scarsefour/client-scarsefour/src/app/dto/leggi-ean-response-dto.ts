import { RigaScontrino } from "../entità/riga-scontrino";
import { Scontrino } from "../entità/scontrino";

export class LeggiEanResponseDto{
    scontrino: Scontrino;
    righeScontrino: RigaScontrino[];
    messaggio: string;
    barcode: string;
}