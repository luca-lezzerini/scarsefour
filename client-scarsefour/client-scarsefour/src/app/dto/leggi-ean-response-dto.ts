import { RigaScontrino } from "../entità/riga-scontrino";
import { Scontrino } from "../entità/scontrino";

export class LeggiEanResponseDto{
    scontrino: Scontrino;
    rigaScontrino: RigaScontrino;
    messaggio: string;
}