/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ListaProdottiDto;
import it.sirfin.scarsefour.model.Prodotto;

/**
 *
 * @author marco
 */
public interface DashBoardCassaMacService {
    
  ListaProdottiDto ricercaProdotto(String barcode);
    
    

}
