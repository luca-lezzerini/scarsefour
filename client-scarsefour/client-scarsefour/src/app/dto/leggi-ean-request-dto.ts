import { Scontrino } from "../entità/scontrino";

export class LeggiEanRequestDto{
    scontrino: Scontrino;
    eanProdotto: string;
}