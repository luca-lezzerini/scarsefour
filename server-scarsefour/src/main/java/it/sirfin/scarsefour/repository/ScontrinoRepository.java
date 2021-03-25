package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScontrinoRepository extends JpaRepository<Scontrino, Long> {

    @Query("SELECT s.numero FROM Scontrino s WHERE s.id = (SELECT MAX(id) FROM Scontrino)")
    int trovaUltimoScontrino();

    @Modifying
    @Query("update Scontrino s set s.totale = :totale where s.id = :id")
    void aggiornaTotScontrino(@Param("totale") double totale, @Param("id") Long id);
    
    @Query("select s.totale from Scontrino s where s.id = :id")
    Double trovaTotale(@Param("id")Long id);
}
