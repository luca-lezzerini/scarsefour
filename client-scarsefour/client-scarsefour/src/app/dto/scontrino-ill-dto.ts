import { RigaScontrino } from "../entità/riga-scontrino";
import { Scontrino } from "../entità/scontrino";
import { RigaScontrinoClientGalDto } from "./riga-scontrino-client-gal-dto";

export class ScontrinoIllDto {
    righeScontrino: RigaScontrinoClientGalDto[] = [];
    scontrino = new Scontrino();
    messaggio = "";
}