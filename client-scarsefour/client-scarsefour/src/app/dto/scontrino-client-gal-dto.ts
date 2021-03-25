import { Scontrino } from "../entità/scontrino";
import { RigaScontrinoClientGalDto } from "./riga-scontrino-client-gal-dto";

export class ScontrinoClientGalDto {
    righeScontrino: RigaScontrinoClientGalDto[] = [];
    scontrino = new Scontrino();
}