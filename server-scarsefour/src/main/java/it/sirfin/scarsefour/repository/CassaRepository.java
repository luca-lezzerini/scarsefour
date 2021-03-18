package it.sirfin.scarsefour.repository;

import it.sirfin.scarsefour.model.Cassa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CassaRepository extends JpaRepository<Cassa, Long> {

    @Modifying
//    @Query("update Cassa c set c.codice = :codice where c.id = :id")
    @Query(value = "update Cassa c set c.codice= ? where c.id = ?",
            nativeQuery = true)
    void modificaCassa(String codice, Long id);
}
