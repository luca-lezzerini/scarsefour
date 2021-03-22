/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ProdottoDto;

/**
 *
 * @author Palo
 */
public interface DashboardCassaIllService {

    ProdottoDto trovaEan(String ean);
}
