import { RigaScontrino } from "../entità/riga-scontrino";
import { Scontrino } from "../entità/scontrino";

export class AnnullaScontrinoDto{
    scontrino = new Scontrino();
    righeScontrino: RigaScontrino[] = [];
}