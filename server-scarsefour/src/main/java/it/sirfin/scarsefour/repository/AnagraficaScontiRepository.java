/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Sconto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaScontiRepository extends JpaRepository<Sconto, Long> {
    
    /*@Query("select c from Sconto c where s.Codice LIKE CONCAT('%',:cod,'%') "     |
            + "s.Codice LIKE CONCAT('%',:cod,'%') or s.Descrizione"                 |
            + "=:desc")*                                                            |
    /*@Query("select s from Sconto s where s.Codice LIKE CONCAT('%',:cod,'%') ")    |
    List<Sconto> findByCodice(@Param("cod") String Codice);                         |WIP*/
    List<Sconto> findByCodice(String s);
    
}
