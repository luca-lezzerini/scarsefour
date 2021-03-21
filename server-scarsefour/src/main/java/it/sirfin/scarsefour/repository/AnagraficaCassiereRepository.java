package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Cassiera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaCassiereRepository extends JpaRepository<Cassiera, Long> {

    /**
     * Query per effettuare la ricerca nome like or cognome like or codice 
     * fiscale uguale.
     * @param cognome parametro relativo al criterio di ricerca
     * @return ritorna una lista di cassiere
     */
    @Query("select c from Cassiera c where c.nome LIKE CONCAT('%',:cogn,'%') "
            + "or c.cognome LIKE CONCAT('%',:cogn,'%') or c.codiceFiscale"
            + "=:cogn")
    List<Cassiera> trovaCassieraPerCognome(@Param("cogn") String cognome);
}
