
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.Scontrino;

public interface GestioneCassaHisService {
    
    ProdottoDto verificaEan(String barcode);
    
    CreaScontrinoDto salvaScontrino(Scontrino scontrino);
}
