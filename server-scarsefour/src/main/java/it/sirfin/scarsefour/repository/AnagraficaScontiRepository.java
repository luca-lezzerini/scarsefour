/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Sconto;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaScontiRepository extends JpaRepository<Sconto, Long> {

    Set<Sconto> findByCodiceContains(String s);

    //void modificaRiga(@Param("codice") String codice, @Param("id") Long id,
          //  @Param("prezzoScontato") String prezzoScontato, @Param("dallaData") LocalDate dallaData,
            //@Param("allaData") LocalDate allaData);

}
