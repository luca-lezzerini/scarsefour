import { Scontrino } from "../entità/scontrino";
import { Prodotto } from "../prodotto";

export class RigaScontrinoClientGalDto {
    idRiga: bigint;
    idScontrino: bigint;
    idProdotto: bigint;
    descrizione = "";
    prezzo = 0;
    quantita = 1;

}