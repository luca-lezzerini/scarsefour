/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.model.Scontrino;

/**
 *
 * @author Palo
 */
public interface DashboardCassaIllService {

    ProdottoDto trovaEan(String ean);

    CreaScontrinoDto creaScont(Scontrino sc);

    CreaRigaDto creaRiga(RigaScontrino rs);
}
