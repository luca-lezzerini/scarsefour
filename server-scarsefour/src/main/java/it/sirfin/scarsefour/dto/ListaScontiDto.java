/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.dto;

import it.sirfin.scarsefour.model.Sconto;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Userù
 */
public class ListaScontiDto {
    
    List<Sconto> listaSconti;

    public ListaScontiDto() {
    }

    public ListaScontiDto(List<Sconto> listaSconti) {
        this.listaSconti = listaSconti;
    }

    public List<Sconto> getListaSconti() {
        return listaSconti;
    }

    public void setListaSconti(List<Sconto> listaSconti) {
        this.listaSconti = listaSconti;
    }

    @Override
    public String toString() {
        return "ListaScontiDto{" + "listaSconti=" + listaSconti + '}';
    }
    
    
}
