/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.RigaScontrino;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RigaRepository extends JpaRepository<RigaScontrino, Long> {

    @Query("Select r from RigaScontrino r where r.scontrino_id = :id")
    List<RigaScontrino> cercaAssociazioneRigaScontrino(@Param("id") Long id);
    
    @Modifying
    @Query("update RigaScontrino r set r.quantita = :quantita")
    void aggiornaQuantita(@Param("quantita") int quantita);
    
    @Query("SELECT s.quantita FROM RigaScontrino s WHERE s.id = :id")
    int leggiQuantita(@Param("id") Long id);
    
}
