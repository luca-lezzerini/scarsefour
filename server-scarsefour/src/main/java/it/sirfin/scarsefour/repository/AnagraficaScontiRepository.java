/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Sconto;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaScontiRepository extends JpaRepository<Sconto, Long> {
    
    
    Set<Sconto> findByCodiceContains(String s);
    
}
