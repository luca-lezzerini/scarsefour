import { Prodotto } from "../prodotto";

export class RigaScontrino {
    id: bigint;
    quantita = 0;
    prodotto = new Prodotto();
}