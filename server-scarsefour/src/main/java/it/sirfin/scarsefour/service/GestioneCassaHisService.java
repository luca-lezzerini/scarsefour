
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ProdottoDto;

public interface GestioneCassaHisService {
    
    ProdottoDto verificaEan(String barcode);
}
