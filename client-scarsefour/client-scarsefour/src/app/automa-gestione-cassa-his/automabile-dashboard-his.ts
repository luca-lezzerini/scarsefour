export interface AutomabileDashboardHis {
    entraStatoVediPrezzo();
    entraStatoScontrinoVuoto();
    entraStatoScontrinoNonVuoto();
    entraStatoAnnullamentoScontrino();
    verificaEan(barcode: string);
}