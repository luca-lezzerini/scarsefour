/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.LeggiEanResponseDto;
import it.sirfin.scarsefour.dto.ScontrinoClientGalDto;
import it.sirfin.scarsefour.model.Scontrino;

public interface DashboardCassaGalService {

    ScontrinoClientGalDto verificaEan(String ean, Scontrino sc);
    
    void demo();
}
