
package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Posizione;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PosizioneRepository extends JpaRepository<Posizione, Long> {
    
    @Modifying
    @Query("update Posizione p set p.codice = :codice, p.descrizione = :descrizione where p.id = :id")
//    @Query(value = "update Cassa c set c.codice= ? where c.id = ?",
//            nativeQuery = true)
    void modificaPosizione(@Param("codice")String codice,@Param("descrizione")String descrizione,@Param("id")Long id);
    
    List<Posizione> findByCodiceContainsOrDescrizioneContains(String codice,String descrizione);
}
