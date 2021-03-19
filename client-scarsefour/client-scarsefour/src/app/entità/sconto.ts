export class Sconto {
    id:bigint;
    codice = "";
    descrizione = "";
    prezzoScontato = 0;
    dallaData: Date;
    allaData: Date;
    prodotti:[]=[];
}