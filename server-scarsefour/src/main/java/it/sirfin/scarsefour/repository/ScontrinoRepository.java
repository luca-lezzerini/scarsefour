package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ScontrinoRepository extends JpaRepository<Scontrino, Long> {

    @Query("SELECT s.numero FROM Scontrino s WHERE s.id = (SELECT MAX(id) FROM Scontrino)")
    int trovaUltimoScontrino();

}
