/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.service;

import it.sirfin.scarsefour.dto.ScontrinoClientMacDto;
import it.sirfin.scarsefour.model.Scontrino;

/**
 *
 * @author marco
 */
public interface DashBoardCassaMacService {
    
  //ListaProdottiDto ricercaProdotto(String barcode);
    
    ScontrinoClientMacDto leggiEan(String ean,Scontrino scon);

}
