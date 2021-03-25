import { RigaScontrino } from "../entità/riga-scontrino";
import { Scontrino } from "../entità/scontrino";
import { RigaScontrinoClientGalDto } from "./riga-scontrino-client-gal-dto";
import { RigaScontrinoDtoIll } from "./riga-scontrino-ill--dto";

export class ScontrinoIllDto {
    righeScontrino: RigaScontrinoDtoIll[] = [];
    scontrino = new Scontrino();
    messaggio = "";
}